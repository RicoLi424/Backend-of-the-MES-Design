package com.example.mes.WorkshopStorage.controller;

import com.example.mes.WorkshopStorage.para.GoodsUpdatePara;
import com.example.mes.WorkshopStorage.service.GoodsService;
import com.example.mes.WorkshopStorage.vo.ApplyVo;
import com.example.mes.WorkshopStorage.vo.GoodsVo;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsContorller {
    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "search")
    Result<List<GoodsVo>> search(String storage_id, String id, String company_id) {
        Result<List<GoodsVo>> result = new Result<>();
        try {
            result = goodsService.search(storage_id, id, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "move")
    public Result<?> move(GoodsUpdatePara params, String company_id) {
        try {
            goodsService.move(params, company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("转移失败", e.getMessage());
            return Result.error("转移失败!");
        }
        return Result.ok("转移成功!");
    }

    @GetMapping(value = "apply")
    public Result<?> apply(String workshop_id, String id, int quantity, String type, String user, String in_out, String storage_id, String shelf_id, String company_id) {
        try {
            goodsService.apply(workshop_id, id, quantity, type, user, in_out, storage_id, shelf_id, company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("提交失败", e.getMessage());
            return Result.error("提交失败!");
        }
        return Result.ok("提交成功!");
    }

    @GetMapping(value = "applyItem")
    public Result<PageVo<ApplyVo>> applyItem(String current, String pages, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.applyItem(current, pages, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "searchApply")
    public Result<PageVo<ApplyVo>> searchApply(String current, String pages, String goods_id, String goods_name, Date time1, Date time2, String type, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.searchApply(current, pages, goods_id, goods_name, time1, time2, type, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "searchQuantity")
    public Result<Integer> searchQuantity(String good_id, String type, String company_id) {
        Result<Integer> result = new Result<>();
        try {
            result = goodsService.searchQuantity(good_id, type, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "setApply")
    public Result<?> setApply(String user, String uuid, String company_id) {
        try {
            goodsService.setApply(uuid, user, company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("提交失败", e.getMessage());
            return Result.error("提交失败!");
        }
        return Result.ok("提交成功!");
    }

    @GetMapping(value = "setApplyItem")
    public Result<PageVo<ApplyVo>> setApplyItem(String current, String pages, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.setApplyItem(current, pages, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "managerConfirm")
    public Result<?> managerConfirm(String uuid, String message, String in_out, String company_id) {
        Result<?> result = new Result<>();
        goodsService.managerConfirm(uuid, message, in_out, company_id);
        return Result.ok("提交成功!");
        /*
        try {
            goodsService.managerConfirm(uuid, message, in_out);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("提交失败", e.getMessage());
            return Result.error("提交失败!");
        }
        return Result.ok("提交成功!");*/
    }

    @GetMapping(value = "confirmItem")
    public Result<PageVo<ApplyVo>> confirmItem(String current, String pages, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.confirmItem(current, pages, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "messageItem")
    public Result<PageVo<ApplyVo>> messageItem(String current, String pages, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.messageItem(current, pages, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "remove")
    public Result<?> remove(String uuid, String user, String company_id) {
        Result<?> result = new Result<>();
//        try {
            goodsService.remove(uuid, user, company_id);
//        } catch (Exception e) {
//            LoggerFactory.getLogger(this.getClass()).error("出库失败", e.getMessage());
//            return Result.error("出库失败!");
//        }
        return Result.ok("出库成功!");
    }


    @GetMapping(value = "addGoods")
    public Result<?> addGoods(String storage_id, String shelf_id, String location, String id, int quantity, String type, String user, String company_id) {
        Result<?> result = new Result<>();
        try {
            goodsService.addGoods(storage_id, shelf_id, location, id, quantity, type, user, company_id);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error("申请失败", e.getMessage());
            return Result.error("申请失败!");
        }
        return Result.ok("申请成功!");
    }

    @GetMapping(value = "addItem")
    public Result<PageVo<ApplyVo>> addItem(String current, String pages, String company_id) {
        Result<PageVo<ApplyVo>> result = new Result<>();
        try {
            result = goodsService.addItem(current, pages, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "addConfirm")
    public Result<?> addConfirm(String uuid, String message, String user, String company_id) {
        Result<?> result = new Result<>();
        try {
            goodsService.addConfirm(uuid, message, user, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "goodsItem")
    public Result<PageVo<GoodsVo>> goodsItem(String current, String pages, String storage_id, String shelf_id, String company_id) {
        Result<PageVo<GoodsVo>> result = new Result<>();
        try {
            result = goodsService.goodsItem(current, pages, storage_id, shelf_id, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "locationItem")
    public Result<PageVo<GoodsVo>> locationItem(String current, String pages, String type, String goods_id, String company_id) {
        Result<PageVo<GoodsVo>> result = new Result<>();
        try {
            result = goodsService.locationItem(current, pages, type, goods_id, company_id);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(this.getClass()).error("" + e.getMessage());
            result.error500(e.getMessage());
        }
        return result;
    }
}