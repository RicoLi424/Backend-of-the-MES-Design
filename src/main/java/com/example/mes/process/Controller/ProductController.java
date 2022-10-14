package com.example.mes.process.Controller;


import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.IProductService;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProductVo.DeleteProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/process")
public class ProductController {

    @Autowired
    IProductService service;

    @GetMapping("/getProducts")
    public String getProducts(int pageOffset,int pageSize){
        try {
            return JSON.toJSONString(service.getProducts(new PageVo(pageOffset,pageSize)));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询产品信息失败");
            return "";
        }
    }

    @GetMapping("/getProductsByCompany")
    public String getProductsByCompany(int pageOffset,int pageSize,String company_id){
        try {
            return JSON.toJSONString(service.getProducts(new PageVo(pageOffset,pageSize),company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询产品信息失败");
            return "";
        }
    }

    @GetMapping("/getProductsByCompanyAndCompany")
    public String getProductsByCompany(int pageOffset,int pageSize,String company_id, String company){
        try {
            return JSON.toJSONString(service.getProducts(new PageVo(pageOffset,pageSize),company_id,company));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询产品信息失败");
            return "";
        }
    }



    @GetMapping("/getProductsByCompanyAndType")
    public String getProductsByCompanyAndType(int pageOffset,int pageSize,String company_id,String type){
        try {
            return JSON.toJSONString(service.getProductsByType(new PageVo(pageOffset,pageSize),company_id,type));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询产品信息失败");
            return "";
        }
    }

//    @Transactional
//    @PostMapping("/deleteProductByCompanyAndID")
//    public String deleteProductByByCompanyAndID(@RequestBody DeleteProductVo deleteProductVo,String company_id){
//        try {
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            deleteProductVo.setModified_time(timestamp);
//            return JSON.toJSONString(service.deleteProductByID(deleteProductVo));
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("controller:删除产品失败");
//            return "删除失败";
//        }
//    }

    @Transactional
    @PostMapping("/deleteProductByID")
    public String deleteProductByID(@RequestBody DeleteProductVo deleteProductVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            deleteProductVo.setModified_time(timestamp);
            return JSON.toJSONString(service.deleteProductByID(deleteProductVo));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除产品失败");
            return "删除失败";
        }
    }

    @GetMapping("/getProductIdsByDate")
    public String getProductIdsByDate(String date){
        try {
            return JSON.toJSONString(service.getProductIdsByDate(date));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
    @GetMapping("/getFinishInfoById")
    public String getFinishInfoById(String demand_id){
        try {
            ArrayList<Integer> realCounts = new ArrayList();
            ArrayList<Integer> planCounts = new ArrayList<>();
            ArrayList<String> categorys = new ArrayList<>();
            for(int i=0;i<12;i++){
                realCounts.add(i);
                planCounts.add(i*2);
                categorys.add("h"+i);
            }
            HashMap<String,Object> data = new HashMap<>();
            data.put("realCounts",realCounts);
            data.put("planCounts",planCounts);
            data.put("categorys",categorys);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}
