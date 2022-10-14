package com.example.mes.process.Controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.IOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptionsController {

    @Autowired
    IOptionsService iOptionsService;

    //为品牌下拉框提供选项
    @GetMapping("/getBrands")
    public String getBrands(){
        try {
            return JSON.toJSONString(iOptionsService.getBrands());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("品牌下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getSeasons")
    public String getSeasons(){
        try {
            return JSON.toJSONString(iOptionsService.getSeasons());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("季节下拉框生成失败！");
            return "";
        }
    }
    @GetMapping("/getTypes")
    public String getTypes(){
        try {
            return JSON.toJSONString(iOptionsService.getTypes());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("季节下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getStyleByBrand")
    public String getStyleByBrand(String brand){
        try {
            return JSON.toJSONString(iOptionsService.getStyleByBrand(brand));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("样式下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getColorByBrandStyle")
    public String getColorByBrandStyle(String brand,String style){
        try {
            return JSON.toJSONString(iOptionsService.getColorByBrandStyle(brand,style));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("颜色下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getRoutingInfosByID")
    public String getRoutingInfosByID(String product_id){
        try {
            return JSON.toJSONString(iOptionsService.getRoutingInfosByID(product_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("根据产品id获取工艺路线信息失败！");
            return "";
        }
    }

    //为颜色下拉框提供选项
    @GetMapping("/getColors")
    public String getColors(){
        try {
            return JSON.toJSONString(iOptionsService.getColors());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("颜色下拉框生成失败！");
            return "";
        }
    }

    //为型号下拉框提供数据
    @GetMapping("/getSizes")
    public String getSizes(){
        try{
            return JSON.toJSONString(iOptionsService.getSizes());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("型号下拉框生成失败！");
            return "";
        }
    }

    //为工序下拉框提供数据
    @GetMapping("/getProcedures")
    public String getProcedures(){
        try {
            return JSON.toJSONString(iOptionsService.getProcedures());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("工序下拉框生成失败！");
            return "";
        }
    }

    //为工序下拉框提供数据
    @GetMapping("/getProceduresByCompany")
    public String getProceduresByCompany(String company_id){
        try {
            return JSON.toJSONString(iOptionsService.getProceduresByCompany(company_id));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("工序下拉框生成失败！");
            return "";
        }
    }

    //为物料拉框准备数据
    @GetMapping("/getOptionMaterial")
    public String getOptionMaterial(){
        try {
            return iOptionsService.getOptionMaterial().toString();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("物料三级下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getOptionMaterialByCompany")
    public String getOptionMaterialByCompany(String company_id){
        try {
            return iOptionsService.getOptionMaterialByCompany(company_id).toString();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("物料三级下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getCompanyIDs")
    public String getCompanyIDs(){
        try {
            return JSON.toJSONString(iOptionsService.getCompanyIDs());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("公司款项下拉框生成失败！");
            return "";
        }
    }

    @GetMapping("/getProductByCompanyID")
    public String getProductByCompanyID(String company_id){
        try {
            System.out.println(company_id);
            return JSON.toJSONString(iOptionsService.getProductByCompanyID(company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("产品信息下拉框生成失败！");
            return "";
        }
    }
}
