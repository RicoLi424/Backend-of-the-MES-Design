package com.example.mes.WorkshopStorage.controller;

import com.example.mes.WorkshopStorage.para.theLinesPara;
import com.example.mes.WorkshopStorage.service.LineService;
import com.example.mes.WorkshopStorage.service.StationService;
import com.example.mes.WorkshopStorage.service.WorkshopService;
import com.example.mes.WorkshopStorage.vo.*;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/line")
public class LineController {
    @Autowired
    private LineService lineService;

    @Autowired
    private WorkshopService workshopService;

    @Autowired
    private StationService stationService;

    //删除产线
    @GetMapping(value = "delete")
    public Result<?> deleteWorkshop(String workshopId, String lineId){
        try {
            lineService.delete(workshopId, lineId);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    //删除产线及下属工位
    @PostMapping(value = "deleteAll")
    public Result<?> deleteLine(String workshopId, String lineId){
        try {
            lineService.delete(workshopId, lineId);
            //搜索下属工位
            List<StationVo> stationVoList = stationService.searchAllStation(workshopId,lineId);
            for(StationVo station : stationVoList){
                stationService.delete(workshopId, lineId, station.getId());
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


   @GetMapping(value = "create")
    public Result<?> create(String workshopId, String lineId, String lineName, String routing){
        try {
            LineVo line = new LineVo();
            line.setId(lineId);
            line.setName(lineName);
            line.setRouting(routing);
            lineService.create(workshopId, line, "insert");
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    //批量增加产线
    @PostMapping(value = "createAll")
    public Result<?> createAll(@RequestBody theLinesPara para){
        try {
            lineService.createAll(para);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败!!",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping(value = "update")
    public Result<?> update(String company_id,String workshopId, String lineId, String newName,String routing){
        try {
            lineService.update(company_id, workshopId, lineId, newName, routing);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }


    @GetMapping(value = "searchLineItem")
    public Result<PageVo<LineVo>> searchLineItem(String currentPage, String pagesize,String company_id) {
        Result<PageVo<LineVo>> result = new Result<>();
        try {
            result = lineService.searchLineItem(currentPage, pagesize,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    //车间里产线的分页
    @GetMapping(value = "getLineItem")
    public Result<PageVo<newLineVo>> getLineItem(String workshopId, String currentPage, String pagesize,String company_id) {

        Result<PageVo<newLineVo>> result = new Result<>();
        try {
            //result = lineService.searchLineItem(currentPage, pagesize);
            result = lineService.getLineItem(workshopId, currentPage, pagesize,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }


    @GetMapping("applyLine")
    public Result<PageVo<StationVo>> applyWorkshop(String current, String pages,String company_id){
        Result<PageVo<StationVo>> result = new Result<>();
        try {
            result = lineService.applyLine(current, pages,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "searchLine")
    public Result<LineVo> searchLine(String Id, String info,String company_id){
        Result<LineVo> result = new Result<>();
        try {
            result = lineService.searchLine(Id, info,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    //产品id边输入边搜索
    @GetMapping(value = "searchProductId")
    public List<QueryProductVo> searchProductId(String company_id) throws Exception{

        return lineService.searchProductId(company_id);
    }


}
