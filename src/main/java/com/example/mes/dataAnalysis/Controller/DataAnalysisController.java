package com.example.mes.dataAnalysis.Controller;


import com.alibaba.fastjson.JSON;
import com.example.mes.dataAnalysis.Service.IDataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    IDataAnalysisService service;

    @GetMapping("getDemandFormNosByDate")
    public String getDemandFormNosByDate(String date,String company_id){
        try {
            return JSON.toJSONString(service.getDemandFormNosByDate(date,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据预计完成日期获得预计完成客户订单号失败！");
            return "";
        }
    }
    @GetMapping("getPlanByProductId")
    public String getPlanByProductId(String product_id){
        try {
            System.out.println(product_id);
            return JSON.toJSONString(service.getPlanByProductId(product_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据产品号获取生产进度失败！");
            return "";
        }
    }
    @GetMapping("/getProcessByPlanId")
    public String getProcessByPlanId(String plan_id)
    {
        try {
            System.out.println(plan_id);
            return JSON.toJSONString(service.getProcessByPlanId(plan_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据产品号获取生产进度失败！");
            return "";
        }
    }
    @GetMapping("/getFinishInfoById")
    public String getFinishInfoById(String demand_id){
        try {
            return JSON.toJSONString(service.getFinishInfoById(demand_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:获取生产进度失败！");
            return "";
        }
    }

    @GetMapping("/getMaterialStock")
    public String getMaterialStock(int pageOffset,int pageSize , String company_id){
        try {
            return JSON.toJSONString(service.getMaterialStock(pageOffset,pageSize,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:获取库存信息失败！");
            return "";
        }
    }

    @GetMapping("/getMaterialStockByInfo")
    public String getMaterialStockByInfo(String name,String size){
        try {
            return JSON.toJSONString(service.getMaterialStockByInfo(name,size));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据物料信息获取库存失败！");
            return "";
        }
    }

    @GetMapping("/getMaterialStockChanges")
    public String getMaterialStockChanges(String material_id){
        try {
            return JSON.toJSONString(service.getMaterialStockChanges(material_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println();
            return "";
        }
    }

    //每天的23点将库存统计信息写入表
    @Scheduled(cron="0 0 23 * * ?")
    public void addMaterialStockChanges(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String str = formatter.format(date);
        try {
            service.addMaterialStockChanges(str);
            System.out.println(str+":库存信息统计成功！");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(str+":库存信息统计失败！");

        }
    }
}
