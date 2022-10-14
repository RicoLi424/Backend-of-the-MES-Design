package com.example.mes.WorkshopStorage.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.WorkshopStorage.para.WorkshopUpdatePara;
import com.example.mes.WorkshopStorage.service.LineService;
import com.example.mes.WorkshopStorage.service.StationService;
import com.example.mes.WorkshopStorage.service.WorkshopService;
import com.example.mes.WorkshopStorage.vo.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/workshop")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;
    @Autowired
    private LineService lineService;
    @Autowired
    private StationService stationService;

    @GetMapping("/mainInfo")
    public Result<newWorkshopVo> mainInfo(String workshopId,String company_id) {
        Result<newWorkshopVo> result = new Result<>();
        try {
            result = workshopService.getById(workshopId,company_id);

        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    //一个车间的详情
    @GetMapping(value = "workshopInfo")
    public newWorkshopVo workshopInfo(String workshopId) {

        return workshopService.getWorkshopInfo(workshopId);
    }



    @GetMapping(value = "delete")
    public Result<?> deleteWorkshop(String workshopId){
//        System.out.println(workshopId);
        try {
            workshopService.deleteWorkshop(workshopId);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }

    //删除车间，产线和工位一起删除
    @PostMapping(value = "deleteAll")
    public Result<?> deleteAll(@RequestParam("workshopId") String workshopId){
        System.out.println(workshopId);
        try {
            workshopService.deleteWorkshop(workshopId);
            //搜索下属产线
            List<LineVo> lineVoList = lineService.searchAllLine(workshopId);
            for(LineVo line : lineVoList){
                lineService.deleteAllLine(workshopId, line.getId());
                //搜索下属工位
                List<StationVo> stationVoList = stationService.searchAllStation(workshopId,line.getId());
                for(StationVo station : stationVoList){
                    stationService.delete(workshopId, line.getId(), station.getId());
                }
            }

        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping(value = "update")
    public Result<?> updateHead(WorkshopUpdatePara para){
        try {
            workshopService.updateHead(para);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @PostMapping(value = "create")
    public Result<?> create(@RequestBody WorkshopVo para){
        try {
            workshopService.create(para);
            for(LineVo line: para.getLines()){
                line.setCompany_id(para.getCompany_id());
                lineService.create(para.getId() ,line, "create");
                for(StationVo station : line.getStations()){
                    stationService.create(para.getId(), line.getId(), station, "create",para.getCompany_id());
                }
            }

        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping(value = "searchWorkshop")
    public Result<WorkshopVo> search(String info,String company_id) {
        System.out.println("车间");
        Result<WorkshopVo> result = new Result<>();
        try {
            result = workshopService.search(info,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "workshopItem")
    public Result<PageVo<WorkshopVo>> workshopItem(String currentPage, String pagesize,String company_id) {
        Result<PageVo<WorkshopVo>> result = new Result<>();
        try {
            result = workshopService.workshopItem(currentPage, pagesize,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "all_workshop")
    public String all_workshop(String company_id){
        try {
            HashMap<String, Object> data = new HashMap<>();
            List<WorkshopVo> workshop = workshopService.all_workshop(company_id);
            data.put("workshop", workshop);
            return(JSON.toJSONString(workshop));
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            return "";
        }
    }

    @GetMapping(value = "applyWorkshop")
    public Result<PageVo<StationVo>> applyWorkshop(String current, String pages,String company_id){
        Result<PageVo<StationVo>> result = new Result<>();
        try {
            result = workshopService.applyWorkshop(current, pages,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "createInfo")
    public Result<WorkshopVo> createInfo(String workshop_id, String line_id, String id){
        Result<WorkshopVo> result = new Result<>();
        try {
            result = workshopService.createInfo(workshop_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "update_delete_Info")
    public Result<List<WorkshopVo>> update_delete_Info(String workshopId, String lineId, String stationId,String company_id){
        Result<List<WorkshopVo>> result = new Result<>();
        try {
            result = workshopService.update_delete_Info(workshopId, lineId, stationId,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "confirm")
    public Result<?> confirm(String user, String info, String workshop_id, String line_id, String id,String company_id){
        //TODO:权限判断
        try {
            workshopService.confirm(user, info, workshop_id, line_id, id,company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("申请失败",e.getMessage());
            return Result.error("申请失败!");
        }
        return Result.ok("申请成功!");
    }
}
