package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.entity.Workshop;
import com.example.mes.WorkshopStorage.mapper.LineMapper;
import com.example.mes.WorkshopStorage.mapper.StationMapper;
import com.example.mes.WorkshopStorage.mapper.WorkshopMapper;
import com.example.mes.WorkshopStorage.para.WorkshopUpdatePara;
import com.example.mes.WorkshopStorage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkshopService {
    @Autowired
    private WorkshopMapper workshopMapper;
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private StationMapper stationMapper;

    public Result<newWorkshopVo> getById(String workshopId,String company_id) {
        Result<newWorkshopVo> result = new Result<>();
        newWorkshopVo workshop = workshopMapper.getWorkshopById(workshopId);
//        List<newLineVo> lineList = lineMapper.getByWorkshop(workshopId);
        List<newLineVo> lineList = lineMapper.getLinesByWorkshop(workshopId);
//        System.out.println(workshopId);
        if(workshop == null){
            return result;
        }
        for (newLineVo line : lineList) {
            List<newStationVo> stationList = stationMapper.getByLine(workshopId, line.getId(),company_id);
            if(stationList != null){
                line.setStationNum(stationList.size());
                line.setStations(stationList);
            }else{
                stationList = new LinkedList<>();
                line.setStations(stationList);
                line.setStationNum(0);
            }
        }
        if(lineList != null) {
            workshop.setLines(lineList);
            workshop.setLineNum(lineList.size());
        }else{
            lineList = new LinkedList<>();
            workshop.setLines(lineList);
            workshop.setLineNum(0);
        }
        result.setResult(workshop);
        return result;
    }



    public void setTime(Workshop workshop) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        workshop.setUuid(uuid);
        workshop.setStatus("0");
        workshop.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        workshop.setCreated_by("1");
        workshop.setModified_by("1");
        workshop.setCreated_time(timestamp);
        workshop.setModified_time(timestamp);
    }

    public void updateHead(WorkshopUpdatePara params) throws SQLException {
        //要修改的车间不在数据库里或者已经有其他申请 除修改以外
        WorkshopVo workshop_ = workshopMapper.getById(params.getWorkshopId(),params.getCompany_id());
        if (workshop_ == null || "".equals(workshop_) || !workshop_.getVerify().equals("normal")) {
            System.out.println("要修改的车间不在数据库里或者已经有其他申请 除修改以外");
            throw new SQLException();
        }
        //要修改的车间已经有修改申请
        workshop_ = workshopMapper.checkByPre_id(params.getWorkshopId());
        if (workshop_ != null) {
            System.out.println("要修改的车间已经有修改申请");
            throw new SQLException();
        }
        //修改后的车间已经存在
        if (params.getNewWorkshopId() != null && !params.getNewWorkshopId().equals("") && workshopMapper.checkById(params.getNewWorkshopId(),params.getCompany_id()) != null) {
            System.out.println("修改后的车间已经存在");
            throw new SQLException();
        }

        Workshop workshop = new Workshop();
        if (StringUtils.isEmpty(params.getNewFactory())) {
            params.setNewFactory(workshopMapper.getById(params.getWorkshopId(),params.getCompany_id()).getFactory_name());
        }
        if (StringUtils.isEmpty(params.getNewWorkshopId())) {
            params.setNewWorkshopId(workshopMapper.getById(params.getWorkshopId(),params.getCompany_id()).getId());
        }
        if (StringUtils.isEmpty(params.getNewWorkshopName())) {
            params.setNewWorkshopName(workshopMapper.getById(params.getWorkshopId(),params.getCompany_id()).getName());
        }
        workshop.setCompany_id(params.getCompany_id());
        workshop.setId(params.getNewWorkshopId());
        workshop.setName(params.getNewWorkshopName());
        workshop.setFactory_name(params.getNewFactory());
        workshop.setVerify("insert");
        workshop.setPre_uuid(params.getWorkshopId());
        setTime(workshop);

        workshopMapper.insert(workshop);
    }



    public void deleteWorkshop(String workshopId) throws SQLException {
        List<LineVo> linelist = lineMapper.checkByWorkshop(workshopId);
//        if (linelist.size() > 0) {
//            throw new SQLException();
//        }
        if(workshopMapper.checkByPre_id(workshopId) != null){
            System.out.println("车间修改过");
            throw new SQLException();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        workshopMapper.deleteWorkshop(workshopId, timestamp);
    }

    //新建车间
    public String create(WorkshopVo params) throws SQLException {
        WorkshopVo workshop_ = workshopMapper.checkById(params.getId(),params.getCompany_id());
        if (workshop_ != null) {
            throw new SQLException();
        }
        Workshop workshop = new Workshop();
        workshop.setCompany_id(params.getCompany_id());
        workshop.setId(params.getId());
        workshop.setName(params.getName());
        workshop.setFactory_name(params.getFactory_name());
        workshop.setVerify("create");
        setTime(workshop);
        workshopMapper.insert(workshop);
        return params.getId();
    }



    public Result<WorkshopVo> search(String workshopId,String company_id) {
        Result<WorkshopVo> result = new Result<>();
        WorkshopVo workshop = new WorkshopVo();
        workshop = workshopMapper.getById(workshopId,company_id);
        if (workshop == null) {
            workshop = workshopMapper.getByName(workshopId,company_id);
            workshopId = workshop.getId();
        }

        Integer cnt = lineMapper.getLineNumById(workshopId,company_id);
        if(cnt == null){
            cnt = 0;
        }
        workshop.setLineNum(cnt);
        cnt = stationMapper.getStationNumByworkshopId(workshopId,company_id);
        if(cnt == null){
            cnt = 0;
        }
        workshop.setStationNum(cnt);
        result.setResult(workshop);
        return result;
    }

    public Result<PageVo<WorkshopVo>> workshopItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<WorkshopVo>> result = new Result<>();
        PageVo<WorkshopVo> pageVo = new PageVo();
        Integer size = workshopMapper.getCount(company_id);
        if(size == null)
            size = 0;
        pageVo.setTotal(size);
        pageVo.setSize((size - 1) / Integer.parseInt(page_size) + 1);
        if (pageVo.getSize() < 0) {
            pageVo.setSize(0);
        }
        if (Integer.parseInt(page) > pageVo.getSize()) {
            throw new SQLException();
        }
        if (Integer.parseInt(page) == pageVo.getSize()) {
            pageVo.setPages((size - 1) % Integer.parseInt(page_size) + 1);
        } else {
            pageVo.setPages(Integer.parseInt(page_size));
        }
        pageVo.setCurrent(Integer.parseInt(page));
        List<WorkshopVo> currentlist = workshopMapper.selectAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages());
        for(WorkshopVo workshop : currentlist){
            if(lineMapper.getLineNumById(workshop.getId(),company_id) != null){
                workshop.setLineNum(lineMapper.getLineNumById(workshop.getId(),company_id));
            }
            if(stationMapper.getStationNumByworkshopId(workshop.getId(),company_id) != null){
                workshop.setStationNum(stationMapper.getStationNumByworkshopId(workshop.getId(),company_id));
            }
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<PageVo<StationVo>> applyWorkshop(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<StationVo>> result = new Result<>();
        PageVo<StationVo> pageVo = new PageVo();
        Integer size = workshopMapper.getApplyCount(company_id);
        if(size == null)
            size = 0;
        pageVo.setTotal(size);
        pageVo.setSize((size - 1) / Integer.parseInt(page_size) + 1);
        if (pageVo.getSize() < 0) {
            pageVo.setSize(0);
        }
        if (Integer.parseInt(page) > pageVo.getSize()) {
            throw new SQLException();
        }
        if (Integer.parseInt(page) == pageVo.getSize()) {
            pageVo.setPages((size - 1) % Integer.parseInt(page_size) + 1);
        } else {
            pageVo.setPages(Integer.parseInt(page_size));
        }
        pageVo.setCurrent(Integer.parseInt(page));
        List<WorkshopVo> currentlist = workshopMapper.selectApplyAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        List<StationVo> resultlist = new LinkedList<>();
        for(WorkshopVo workshop : currentlist){
            StationVo station = new StationVo();
            station.setWorkshop_id(workshop.getId());
            if(workshop.getVerify().equals("delete")) {
                station.setCreated_time(workshop.getModified_time());
                station.setCreated_by(workshop.getModified_by());
            }
            else {
                station.setCreated_time(workshop.getCreated_time());
                station.setCreated_by(workshop.getCreated_by());
            }
            if(workshop.getVerify().equals("insert")){
                if(workshop.getPre_id() == null || workshop.getPre_id().equals("")){
                    workshop.setVerify("create");
                }else{
                    workshop.setVerify("update");
                }
            }
            station.setVerify(workshop.getVerify());
            resultlist.add(station);
        }
        pageVo.setRecords(resultlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<WorkshopVo> createInfo(String workshopId){
        Result<WorkshopVo> workshopVoResult = new Result<>();

        WorkshopVo workshopVo = workshopMapper.createInfo(workshopId);
        List<LineVo> lineVoList = lineMapper.createInfo(workshopId);
        for(LineVo lineVo : lineVoList){
            lineVo.setStations(stationMapper.createInfo(workshopId, lineVo.getId()));
        }
        workshopVo.setLines(lineVoList);
        workshopVoResult.setResult(workshopVo);
        return workshopVoResult;
    }

    public List<WorkshopVo> all_workshop(String company_id){
        return workshopMapper.all_workshop(company_id);
    }

    public Result<List<WorkshopVo>> update_delete_Info(String workshopId, String lineId, String stationId,String company_id){
        Result<List<WorkshopVo>> listResult = new Result<>();
        List<WorkshopVo> workshopVoList = new LinkedList<>();
        List<LineVo> lineVoList = new LinkedList<>();
        List<StationVo> stationVoList = new LinkedList<>();
        String type ="undefined";
        String pre_id = "";
        if(stationId != null){
            workshopVoList.add(workshopMapper.getById(workshopId,company_id));
            lineVoList.add(lineMapper.getById(workshopId, lineId));
            stationVoList.add(stationMapper.getApplyById(workshopId, lineId, stationId,company_id));
            lineVoList.get(0).setStations(stationVoList);
            workshopVoList.get(0).setLines(lineVoList);
            type = stationVoList.get(0).getVerify();
            pre_id = stationVoList.get(0).getPre_id();
        }else
        if(lineId != null){
            workshopVoList.add(workshopMapper.getById(workshopId,company_id));
            lineVoList.add(lineMapper.getApplyById(workshopId, lineId,company_id));
            stationVoList.add(new StationVo());
            lineVoList.get(0).setStations(stationVoList);
            workshopVoList.get(0).setLines(lineVoList);
            type = lineVoList.get(0).getVerify();
            pre_id = lineVoList.get(0).getPre_id();
        }else{
            workshopVoList.add(workshopMapper.getApplyById(workshopId,company_id));
            lineVoList.add(new LineVo());
            stationVoList.add(new StationVo());
            lineVoList.get(0).setStations(stationVoList);
            workshopVoList.get(0).setLines(lineVoList);
            type = workshopVoList.get(0).getVerify();
            pre_id = workshopVoList.get(0).getPre_id();
        }
        List<LineVo> lineVoList1 = new LinkedList<>();
        List<StationVo> stationVoList1 = new LinkedList<>();
        if(type.equals("insert") && !(pre_id == null || pre_id.equals(""))){
            if(lineId == null){
                workshopVoList.add(workshopMapper.getById(pre_id,company_id));
                lineVoList1.add(new LineVo());
                stationVoList1.add(new StationVo());
            }
            else{
                workshopVoList.add(workshopMapper.getById(workshopId,company_id));
                if(stationId == null){
                    lineVoList1.add(lineMapper.getById(workshopId, pre_id));
                    stationVoList1.add(new StationVo());
                }else{
                    lineVoList1.add(lineMapper.getById(workshopId, lineId));
                    stationVoList1.add(stationMapper.getById(workshopId, lineId, pre_id));

                }

            }
            workshopVoList.get(1).setLines(lineVoList1);
            lineVoList1.get(0).setStations(stationVoList1);

        }else{
            if(lineId != null)
            workshopVoList.add(workshopMapper.getById(workshopId,company_id));
            else
            workshopVoList.add(new WorkshopVo());
            if(stationId != null){
                lineVoList1.add(lineMapper.getById(workshopId, lineId));
            }
            else
            lineVoList1.add(new LineVo());
            stationVoList1.add(new StationVo());
            lineVoList1.get(0).setStations(stationVoList1);
            workshopVoList.get(1).setLines(lineVoList1);
        }
        if(!type.equals("delete")){
            Collections.swap(workshopVoList, 0, 1);
        }
        listResult.setResult(workshopVoList);

        return listResult;
    }

    public void confirm(String user, String info, String workshopId, String lineId, String stationId,String company_id){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(lineId == null){
            //车间申请
            WorkshopVo workshopVo = workshopMapper.getApplyById(workshopId,company_id);
            if(info.equals("1")){
                if(workshopVo.getVerify().equals("create")){
                    workshopMapper.setNormal(workshopId, timestamp, user,company_id);
                    lineMapper.setNormalByWorkshop(workshopId, timestamp, user,company_id);
                    stationMapper.setNormalByWorkshop(workshopId, timestamp, user,company_id);
                }
                if (workshopVo.getVerify().equals("insert") && workshopVo.getPre_id() != null) {
                    workshopMapper.setDelete(workshopVo.getPre_id(),timestamp, user,company_id);
                    workshopMapper.setNormal(workshopId,timestamp, user,company_id);
                    lineMapper.updateByWorkshop(workshopId, workshopVo.getPre_id(),company_id);
                    stationMapper.updateByWorkshop(workshopId, workshopVo.getPre_id(),company_id);
                }
                if(workshopVo.getVerify().equals("delete")){
                    workshopMapper.setNormal(workshopId, timestamp, user,company_id);
                    workshopMapper.setDelete(workshopId, timestamp, user,company_id);
                }
            }else{
                if(workshopVo.getVerify().equals("create")){
                    workshopMapper.setNormalDelete(workshopId, timestamp, user,company_id);
                    lineMapper.setDeleteByWorkshop(workshopId, timestamp, user,company_id);
                    stationMapper.setDeleteByWorkshop(workshopId, timestamp, user,company_id);
                }
                if (workshopVo.getVerify().equals("insert") && workshopVo.getPre_id() != null) {
                    workshopMapper.setNormalDelete(workshopId, timestamp, user,company_id);
                }
                if(workshopVo.getVerify().equals("delete")){
                    workshopMapper.setNormal(workshopId, workshopVo.getCreated_time(), user,company_id);
                    lineMapper.setNormalByWorkshop2(workshopId, timestamp, user,company_id);
                    stationMapper.setNormalByWorkshop2(workshopId, timestamp, user,company_id);
                }
            }
        }else
        if(stationId == null){
            //产线申请
            LineVo lineVo = lineMapper.getApplyById(workshopId, lineId,company_id);
            if(info.equals("1")){
                if(lineVo.getVerify().equals("delete")){
                    lineMapper.setNormal(workshopId, lineId, timestamp, user,company_id);
                    lineMapper.setDelete(workshopId, lineId, timestamp, user,company_id);
                }
                if(lineVo.getVerify().equals("insert") && lineVo.getPre_id() == null){
                    lineMapper.setNormal(workshopId, lineId, timestamp, user,company_id);
                }
                if(lineVo.getVerify().equals("insert") && lineVo.getPre_id() != null){
                    lineMapper.setDelete(workshopId, lineVo.getPre_id(), timestamp, user,company_id);
                    lineMapper.setNormal(workshopId, lineId, timestamp, user,company_id);
                    stationMapper.updateByLine(workshopId, lineId, lineVo.getPre_id(),company_id);
                }
            }else{
                if(lineVo.getVerify().equals("insert") && lineVo.getPre_id() == null){
                    //增加产线
                    lineMapper.setNormal(workshopId, lineId, timestamp, user,company_id);
                    lineMapper.setDelete(workshopId, lineId, timestamp, user,company_id);
                    stationMapper.setNormal2(workshopId, lineId, timestamp, user,company_id);
                }
                if (lineVo.getVerify().equals("insert") && lineVo.getPre_id() != null) {
                    //修改产线
                    lineMapper.setNormalDelete(workshopId, lineId, timestamp, user,company_id);
                }
                if(lineVo.getVerify().equals("delete")){
                    //删除产线
                    lineMapper.setNormal(workshopId, lineId, lineVo.getCreated_time(), user,company_id);
                    stationMapper.setNormal2(workshopId, lineId, timestamp, user,company_id);
                }
            }
        }
        else{
            //工位申请
            StationVo stationVo = stationMapper.getApplyById(workshopId, lineId, stationId,company_id);
            if(info.equals("1")){
                if(stationVo.getVerify().equals("delete")){
                    stationMapper.setNormal(workshopId, lineId, stationId, timestamp, user,company_id);
                    stationMapper.setDelete(workshopId, lineId, stationId, timestamp, user,company_id);
                }
                if(stationVo.getVerify().equals("insert") && stationVo.getPre_id() == null){
                    stationMapper.setNormal(workshopId, lineId, stationId, timestamp, user,company_id);
                }
                if(stationVo.getVerify().equals("insert") && stationVo.getPre_id() != null){
                    stationMapper.setDelete(workshopId, lineId, stationVo.getPre_id(), timestamp, user,company_id);
                    stationMapper.setNormal(workshopId, lineId, stationVo.getPre_id(), timestamp, user,company_id);
                }
            }else{
                if(stationVo.getVerify().equals("insert") && stationVo.getPre_id() == null){
                    stationMapper.setNormal(workshopId, lineId, stationId, timestamp, user,company_id);
                    stationMapper.setDelete(workshopId, lineId, stationId, timestamp, user,company_id);
                }
                if (stationVo.getVerify().equals("insert") && stationVo.getPre_id() != null) {
                    stationMapper.setNormalDelete(workshopId, lineId, stationId, timestamp, user,company_id);
                }
                if(stationVo.getVerify().equals("delete")){
                    stationMapper.setNormal(workshopId, lineId, stationId, stationVo.getCreated_time(), user,company_id);
                }
            }
        }
    }

    //一个车间的详情
    public newWorkshopVo getWorkshopInfo(String workshopId) {
        return workshopMapper.getWorkshopInfo(workshopId);
    }
}