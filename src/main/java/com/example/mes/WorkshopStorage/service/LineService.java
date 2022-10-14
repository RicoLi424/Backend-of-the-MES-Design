package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.entity.Line;
import com.example.mes.WorkshopStorage.mapper.LineMapper;
import com.example.mes.WorkshopStorage.mapper.StationMapper;
import com.example.mes.WorkshopStorage.mapper.WorkshopMapper;
import com.example.mes.WorkshopStorage.para.LinePara;
import com.example.mes.WorkshopStorage.para.theLinesPara;
import com.example.mes.WorkshopStorage.vo.*;
import com.example.mes.process.Mapper.RoutingMapper;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;
import com.example.mes.process.Vo.RoutingVo.QueryRoutingProcedureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class LineService {
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private StationMapper stationMapper;
    @Autowired
    private WorkshopMapper workshopMapper;
    @Autowired
    private RoutingMapper routingMapper;


    public void setTime(Line line){
        String uuid = UUID.randomUUID().toString().replace("-","");
        line.setUuid(uuid);
        line.setStatus("0");
        line.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        line.setCreated_by("1");
        line.setModified_by("1");
        line.setCreated_time(timestamp);
        line.setModified_time(timestamp);
    }


    public void create(String workshopId, LineVo params, String type) throws SQLException {
//        //车间不存在
//        if(!type.equals("create") && workshopMapper.getById(workshopId) == null){
//            throw new SQLException();
//        }
//
//        //产线已经存在
//        LineVo lineVo = lineMapper.checkById(workshopId, params.getId());
//        if(lineVo!=null && (params.getPre_id()==null || params.getPre_id().equals(""))){
//            throw new SQLException();
//        }
        Line line = new Line();
        line.setId(params.getId());
        line.setWorkshop_id(workshopId);
        line.setName(params.getName());
        line.setVerify(type);
        line.setPre_id(params.getPre_id());
        line.setRouting(params.getRouting());
        line.setCompany_id(params.getCompany_id());
        setTime(line);
        lineMapper.insert(line);

        //根据routing_id查对应的工序
        ArrayList<QueryRoutingProcedureVo> procedure = routingMapper.getRoutingInfosByID(params.getRouting());
        int i = 1;
        System.out.println("size:"+procedure.size());
        //根据工序自动添加工位
        for(QueryRoutingProcedureVo q:procedure){

            StationVo stationVo = new StationVo();
            stationVo.setId(q.getProcedure_id());
            stationVo.setWorkshop_id(workshopId);
            stationVo.setLine_id(params.getId());
            stationVo.setStationOrder(Integer.toString(i));
            stationVo.setVerify("normal");
            stationVo.setCompany_id(params.getCompany_id());

            String uuid = UUID.randomUUID().toString().replace("-","");
            stationVo.setUuid(uuid);
            stationVo.setStatus("0");
            stationVo.setIs_deleted("0");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            stationVo.setCreated_by("1");
            stationVo.setModified_by("1");
            stationVo.setCreated_time(timestamp);
            stationVo.setModified_time(timestamp);

            stationMapper.insertStations(stationVo);
            i++;

        }
    }


    //批量增加产线 并 根据工序自动添加工位
    public void createAll(theLinesPara params) throws SQLException {

        for(LinePara linepara: params.getLines()) {

            //产线已经存在
            LineVo lineVo = lineMapper.checkById(params.getTheWorkshopId(), linepara.getNewLineId(),params.getCompany_id());
            if (lineVo != null && (linepara.getPre_id() == null || linepara.getPre_id().equals(""))) {
                throw new SQLException();
            }

            Line line = new Line();
            line.setId(linepara.getNewLineId());
            line.setWorkshop_id(params.getTheWorkshopId());
            line.setName(linepara.getNewLineName());
            line.setVerify("insert");
            line.setPre_id(linepara.getPre_id());
            line.setRouting(linepara.getNewLineRouting());
            line.setCompany_id(params.getCompany_id());
            setTime(line);
            lineMapper.insert(line);

            //根据routing_id查对应的工序
            ArrayList<QueryRoutingProcedureVo> procedure = routingMapper.getRoutingInfosByID(linepara.getNewLineRouting());
            int i = 1;
            System.out.println("size:"+procedure.size());
            //根据工序自动添加工位
            for(QueryRoutingProcedureVo q:procedure){

                StationVo stationVo = new StationVo();
                stationVo.setId(q.getProcedure_id());
                stationVo.setWorkshop_id(params.getTheWorkshopId());
                stationVo.setLine_id(linepara.getNewLineId());
                stationVo.setStationOrder(Integer.toString(i));
                stationVo.setVerify("normal");
                stationVo.setCompany_id(params.getCompany_id());

                String uuid = UUID.randomUUID().toString().replace("-","");
                stationVo.setUuid(uuid);
                stationVo.setStatus("0");
                stationVo.setIs_deleted("0");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                stationVo.setCreated_by("1");
                stationVo.setModified_by("1");
                stationVo.setCreated_time(timestamp);
                stationVo.setModified_time(timestamp);

                stationMapper.insertStations(stationVo);

//                StationService stationService = new StationService();
//                stationService.createStations(params.getTheWorkshopId(),linepara.getNewLineId(),params.getCompany_id(),q.getProcedure_id(),i,"normal");
                i++;

            }

        }

    }


    public void delete(String workshopId, String lineId) throws SQLException {
        List<StationVo> stationlist = stationMapper.checkByLine(workshopId, lineId);
//        if(stationlist.size() > 0){
//            throw new SQLException();
//        }
        if(lineMapper.checkByPre_id(workshopId, lineId) != null){
            System.out.println("产线正在修改中");
            throw new SQLException();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lineMapper.delete(workshopId, lineId, timestamp);
    }


    public void update(String company_id,String workshopId, String lineId, String newName, String routing) throws SQLException {

        //要修改的车间不在数据库里或者已经有其他申请 除修改以外
        LineVo line_ = lineMapper.getById(workshopId, lineId);
        LineVo line = new LineVo();
        if(line_ == null || !line_.getVerify().equals("normal")){
            throw new SQLException();
        }

        //要修改的车间已经有修改申请
        LineVo line__ = lineMapper.getUpdate(line_.getId());
        if(line__ != null){
            throw new SQLException();
        }
        if(newName == null){
            newName = line_.getName();
        }
        if(routing == null){
            routing = line_.getRouting();
        }
        line.setId(lineId);
        line.setName(newName);
        line.setRouting(routing);
        line.setPre_id(line_.getId());
        line.setCompany_id(company_id);

        //查找该产线的所有工位
        List<StationVo> station = stationMapper.selectAllStation(workshopId,lineId);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //删除原来工序的工位
        for(StationVo s:station){
            stationMapper.delete(workshopId, lineId, s.getId(), timestamp);
        }

        create(workshopId, line, "insert");



//        Line line = new Line();
//        line.setId(lineId);
//        line.setWorkshop_id(workshopId);
//        line.setName(newName);
//        line.setVerify("insert");
//        lineMapper.(workshopId, lineId, timestamp);
    }

//    public Result<List<LineVo>> getByWorkshop(int workshop_id){
//
//        Result<List<LineVo>> result = new Result<List<LineVo>>();
//        List<LineVo> LineVoList = lineMapper.getByWorkshop(workshop_id);
//        result.setResult(LineVoList);
//        return result;
//    }
    public Result<PageVo<LineVo>> searchLineItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<LineVo>> result = new Result<>();
        PageVo<LineVo> pageVo = new PageVo();
        Integer size = lineMapper.getCount(company_id);
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
        List<LineVo> currentlist = lineMapper.selectAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        for(LineVo line : currentlist){
            Integer cnt;
            cnt = stationMapper.getStationNumByLineId(line.getWorkshop_id(), line.getId(),company_id);
            if(cnt != null){
                line.setStationNum(cnt);
            }
            cnt = stationMapper.getEquipNumByLineId(line.getWorkshop_id(), line.getId(),company_id);
            if(cnt != null){
                line.setEquipNum(cnt);
            }
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    //车间里产线的分页
    public Result<PageVo<newLineVo>> getLineItem(String workshopId, String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<newLineVo>> result = new Result<>();
        PageVo<newLineVo> pageVo = new PageVo();
        Integer size = lineMapper.getCountByWorkshopId(workshopId,company_id);
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
//        List<LineVo> currentlist = lineMapper.selectAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages());
        List<newLineVo> currentlist = lineMapper.selectPageLines(workshopId,company_id,(pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages());
        for(newLineVo line : currentlist){
            Integer cnt;
            cnt = stationMapper.getStationNumByLineId(workshopId, line.getId(),company_id);
            if(cnt != null){
                line.setStationNum(cnt);
            }
            //查找该产线的所有工位
            List<newStationVo> station = stationMapper.getByLine(workshopId, line.getId(),company_id);
            line.setStations(station);
            cnt = stationMapper.getEquipNumByLineId(workshopId, line.getId(),company_id);
            if(cnt != null){
                line.setEquipNum(cnt);
            }
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<PageVo<StationVo>> applyLine(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<StationVo>> result = new Result<>();
        PageVo<StationVo> pageVo = new PageVo();
        Integer size = lineMapper.getApplyCount(company_id);
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
        List<LineVo> currentlist = lineMapper.selectApplyAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(), company_id);
        List<StationVo> resultlist = new LinkedList<>();
        for(LineVo line : currentlist){
            StationVo station = new StationVo();
            station.setWorkshop_id(line.getWorkshop_id());
            station.setLine_id(line.getId());
            if(line.getVerify().equals("delete")) {
                station.setCreated_time(line.getModified_time());
                station.setCreated_by(line.getModified_by());
            }
            else {
                station.setCreated_time(line.getCreated_time());
                station.setCreated_by(line.getCreated_by());
            }
            if(line.getVerify().equals("insert")){
                if(line.getPre_id() == null || line.getPre_id().equals("")){
                    line.setVerify("create");
                }else{
                    line.setVerify("update");
                }
            }
            station.setVerify(line.getVerify());
            resultlist.add(station);
        }
        pageVo.setRecords(resultlist);
        result.setResult(pageVo);
        return result;
    }


    public Result<LineVo> searchLine(String workshopId, String lineId, String company_id) throws SQLException{
        Result<LineVo> result = new Result<>();
        WorkshopVo workshopVo = workshopMapper.getById(workshopId,company_id);
        System.out.println(workshopVo.getId());
        if(workshopVo == null){
            workshopVo = workshopMapper.getByName(workshopId,company_id);
            workshopId = workshopVo.getId();
        }
        LineVo lineVo = lineMapper.getById(workshopId, lineId);
        if(lineVo == null){
            lineVo = lineMapper.getByName(workshopId, lineId);
        }
        lineVo.setEquipNum(stationMapper.getEquipNumByLineId(workshopId, lineVo.getId(),company_id));
        lineVo.setStationNum(stationMapper.getStationNumByLineId(workshopId, lineVo.getId(),company_id));
        result.setResult(lineVo);
        return result;
    }


    public List<LineVo> searchAllLine(String workshopId){
        List<LineVo> line = lineMapper.selectAllLine(workshopId);
        return line;

    }

    public void deleteAllLine(String workshopId, String lineId) throws SQLException {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lineMapper.deleteAllLine(workshopId, lineId, timestamp);
    }

    public List<QueryProductVo> searchProductId(String company_id) {
        return lineMapper.searchProductId(company_id);
    }
}
