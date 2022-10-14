package com.example.mes.WorkshopStorage.controller;

import com.example.mes.WorkshopStorage.para.StationPara;
import com.example.mes.WorkshopStorage.para.theLinesPara;
import com.example.mes.WorkshopStorage.service.StationService;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.StationVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping(value = "create")
    public Result<?> create(String workshopId, String lineId, StationPara param){

        try {
            StationVo station = new StationVo();
            station.setWorkshop_id(param.getWorkshopId());
            station.setLine_id(param.getLineId());
            station.setId(param.getStationId());
            station.setStationOrder(param.getStaOrd());
            station.setUser(param.getUser());
            station.setEquip_id(param.getStaEqu());
            station.setCompany_id(param.getCompany_id());
            stationService.create(workshopId, lineId, station, "insert",param.getCompany_id());
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }

    //批量增加工位
//    @PostMapping(value = "createAll")
//    public Result<?> create(@RequestBody theLinesPara para){
//        try {
//            lineService.createAll(para);
//        } catch (Exception e) {
//            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
//            return Result.error("申请提交失败!");
//        }
//        return Result.ok("申请提交成功!");
//    }

    @GetMapping(value = "delete")
    public Result<?> delete(String workshopId, String lineId, String stationId){
        try {
            stationService.delete(workshopId, lineId, stationId);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping(value = "update")
    public Result<?> update(String workshopId, String lineId, StationPara param){
        try {
            StationVo station = new StationVo();
            station.setCompany_id(param.getCompany_id());
            station.setWorkshop_id(param.getWorkshopId());
            station.setLine_id(param.getLineId());
            station.setId(param.getStationId());
            station.setStationOrder(param.getStaOrd());
            station.setUser(param.getUser());
            station.setEquip_id(param.getStaEqu());
            stationService.update(workshopId, lineId, station);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping("applyStation")
    public Result<PageVo<StationVo>> applyWorkshop(String current, String pages,String company_id){
        Result<PageVo<StationVo>> result = new Result<>();
        try {
            result = stationService.applyStation(current, pages,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

}
