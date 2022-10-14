package com.example.mes.WorkshopStorage.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.WorkshopStorage.para.GoodsUpdatePara;
import com.example.mes.WorkshopStorage.service.ShelfService;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.ShelfVo;
import com.example.mes.WorkshopStorage.vo.StorageVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    private ShelfService shelfservice;

    @GetMapping(value = "shelfItemById")
    public Result<PageVo<ShelfVo>> shelfItemById(String storage_id, String user, String current, String pages,String company_id){
        Result<PageVo<ShelfVo>> result = new Result<>();
        try {
            result = shelfservice.shelfItemById(storage_id, current, pages,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "shelfById")
    public String shelfById(String storage_id,String company_id){
        try {
            HashMap<String, Object> data = new HashMap<>();
            List<ShelfVo> shelf = shelfservice.shelfById(storage_id,company_id);
            data.put("shelf", shelf);
            return(JSON.toJSONString(shelf));
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            return "";
        }
    }

    @GetMapping(value = "search")
    public Result<List<ShelfVo>> searchShelf(String storage_id, String id,String company_id){
        Result<List<ShelfVo>> result = new Result<>();
        try {
            result = shelfservice.search(storage_id, id,company_id);
        }catch (Exception e){
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error(""+e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }


    @GetMapping(value="move")
    public Result<?> move(GoodsUpdatePara params,String company_id){
        try {
            shelfservice.move(params,company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("转移失败",e.getMessage());
            return Result.error("转移失败!");
        }
        return Result.ok("转移成功!");
    }

    @GetMapping(value = "insert")
    public Result<?> insert(String storage_id, String id, String user,String company_id){
        try {
            shelfservice.insert(storage_id, id, user,company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("添加失败",e.getMessage());
            return Result.error("添加失败!");
        }
        return Result.ok("添加成功!");
    }

    @GetMapping(value = "delete")
    public Result<?> delete(String storage_id, String id, String user,String company_id){
        try {
            shelfservice.delete(storage_id, id, user,company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("删除失败",e.getMessage());
            return Result.error("删除失败!");
        }
        return Result.ok("删除成功!");
    }
}
