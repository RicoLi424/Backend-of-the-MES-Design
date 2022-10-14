package com.example.mes.WorkshopStorage.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.WorkshopStorage.para.StoragePara;
import com.example.mes.WorkshopStorage.service.StorageService;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.StorageVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping(value = "storageItem")
    public Result<PageVo<StorageVo>> storageItem(String current, String pages, String company_id){
        Result<PageVo<StorageVo>> result = new Result<>();
        try {
            result = storageService.storageItem(current, pages,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "all_storage")
    public String all_storage(String company_id){
        try {
            HashMap<String, Object> data = new HashMap<>();
            List<StorageVo> storage = storageService.all_storage(company_id);
            data.put("storage", storage);
            return(JSON.toJSONString(storage));
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            return "";
        }
    }

    @GetMapping(value = "delete")
    public Result<?> deleteWorkshop(String storage_id, String user, String company_id){
        try {
            storageService.delete(storage_id, user,company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请提交失败",e.getMessage());
            return Result.error("申请提交失败!");
        }
        return Result.ok("申请提交成功!");
    }

    @GetMapping(value = "search")
    public Result<StorageVo> searchLine(String storage_id, String company_id){
        Result<StorageVo> result = new Result<>();
        try {
            result = storageService.search(storage_id,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @PostMapping(value = "create")
    public Result<?> create(@RequestBody StoragePara para){
        try {
            storageService.create(para);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("创建失败",e.getMessage());
            return Result.error("创建失败!");
        }
        return Result.ok("创建成功!");
    }

}
