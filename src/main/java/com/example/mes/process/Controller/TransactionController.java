package com.example.mes.process.Controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.ITransactionService;
import com.example.mes.process.Vo.TransactionVo.InsertVo;
import com.example.mes.process.Vo.TransactionVo.InsertVopro;
import com.example.mes.process.Vo.TransactionVo.UpdateVo;
import com.example.mes.process.Vo.TransactionVo.UpdateVopro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class TransactionController {

    @Autowired
    ITransactionService service;

    @GetMapping("/getInfosByID")
    public String getInfosByID(String product_id){
        try {
            return JSON.toJSONString(service.getInfosByID(product_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询产品详细信息失败！");
            return "";
        }
    }



    @Transactional
    @PostMapping("/add")
    public String add(@RequestBody InsertVo insertVo){
        try {
            return service.add(insertVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加产品详细信息失败！");
            return "添加失败";
        }
    }


    //适应不同模板
    @Transactional
    @PostMapping("/add2")
    public String add2(@RequestBody InsertVopro insertVopro){
        try {
            return service.add2(insertVopro);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加产品详细信息失败！");
            return "添加失败";
        }
    }


    //适应不同模板
    @Transactional
    @PostMapping("/add3")
    public String add3(@RequestBody InsertVo insertVo){
        try {
            return service.add3(insertVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加产品详细信息失败！");
            return "添加失败";
        }
    }

    @Transactional
    @PostMapping("update")
    public String update(@RequestBody UpdateVo updateVo){
        try {
            return service.update(updateVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新产品详细信息失败！");
            return "更新失败";
        }
    }

    @Transactional
    @PostMapping("update2")
    public String update2(@RequestBody UpdateVopro updateVopro){
        try {
            return service.update2(updateVopro);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新产品详细信息失败！");
            return "更新失败";
        }
    }

}
