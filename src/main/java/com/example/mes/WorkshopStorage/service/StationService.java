package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.mapper.LineMapper;
import com.example.mes.WorkshopStorage.mapper.StationMapper;
import com.example.mes.WorkshopStorage.mapper.WorkshopMapper;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.StationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class StationService {
    @Autowired
    private StationMapper stationMapper;
    @Autowired
    private WorkshopMapper workshopMapper;
    @Autowired
    private LineMapper lineMapper;

    public void setTime(StationVo station){
        String uuid = UUID.randomUUID().toString().replace("-","");
        station.setUuid(uuid);
        station.setStatus("0");
        station.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        station.setCreated_by("1");
        station.setModified_by("1");
        station.setCreated_time(timestamp);
        station.setModified_time(timestamp);
    }

    public void create(String workshopId, String lineId, StationVo params, String type,String company_id)throws SQLException {
        //车间不存在
        if(!type.equals("create") && workshopMapper.getById(workshopId,company_id) == null){
            System.out.println("车间不存在");
            throw new SQLException();
        }
        //产线不存在
        if(!type.equals("create") && lineMapper.getById(workshopId, lineId) == null){
            System.out.println("产线不存在");
            throw new SQLException();
        }
        //工位已经存在
        if(stationMapper.checkById(workshopId, lineId, params.getId()) != null && (params.getPre_id()==null || params.getPre_id().equals(""))){
            System.out.println("工位已经存在");
            throw new SQLException();
        }
        StationVo stationVo = new StationVo();
        stationVo.setId(params.getId());
        stationVo.setWorkshop_id(workshopId);
        stationVo.setLine_id(lineId);
        stationVo.setUser(params.getUser());
        stationVo.setEquip_id(params.getEquip_id());
        stationVo.setPre_id(params.getPre_id());
        stationVo.setStationOrder(params.getStationOrder());
        stationVo.setVerify(type);
        stationVo.setCompany_id(params.getCompany_id());
        setTime(stationVo);
        stationMapper.insert(stationVo);
    }



    public void delete(String workshopId, String lineId, String stationId) throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(stationMapper.checkByPre_id(workshopId, lineId, stationId) != null){
            System.out.println("工位正在修改中");
            throw new SQLException();
        }
        stationMapper.delete(workshopId, lineId, stationId, timestamp);
    }

    public void update(String workshopId, String lineId, StationVo param) throws SQLException{
        //要修改的车间不在数据库里或者已经有其他申请 除修改以外
        StationVo station_ = stationMapper.getById(workshopId, lineId, param.getId());
        if(station_ == null || !station_.getVerify().equals("normal")){
            throw new SQLException();
        }
        //要修改的车间已经有修改申请
        StationVo station__ = stationMapper.getUpdate(station_.getUuid());
        if(station__ != null){
            throw new SQLException();
        }
        param.setPre_id(station_.getId());
        create(workshopId, lineId, param, "insert",param.getCompany_id());
    }

    public Result<PageVo<StationVo>> applyStation(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<StationVo>> result = new Result<>();
        PageVo<StationVo> pageVo = new PageVo();
        Integer size = stationMapper.getApplyCount(company_id);
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
        List<StationVo> currentlist = stationMapper.selectApplyAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        for(StationVo station : currentlist){
            if(station.getVerify().equals("delete")) {
                station.setCreated_time(station.getModified_time());
                station.setCreated_by(station.getModified_by());
            }
            if(station.getVerify().equals("insert")){
                if(station.getPre_id() == null || station.getPre_id().equals("")){
                    station.setVerify("create");
                }else{
                    station.setVerify("update");
                }
            }
            station.setVerify(station.getVerify());
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public List<StationVo> searchAllStation(String workshopId, String lineId) {
        List<StationVo> station = stationMapper.selectAllStation(workshopId,lineId);
        return station;
    }
}
