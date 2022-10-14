package com.example.mes.process.Service.Impl;

import com.example.mes.process.Mapper.OptionsMapper;
import com.example.mes.process.Mapper.RoutingMapper;
import com.example.mes.process.Service.IOptionsService;
import com.example.mes.process.Vo.OptionsVo.OptionMaterial;
import com.example.mes.process.Vo.OptionsVo.OptionSize;
import com.example.mes.process.Vo.RoutingVo.QueryRoutingProcedureVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OptionsService implements IOptionsService {

    @Autowired(required = false)
    OptionsMapper mapper;
    @Autowired(required = false)
    RoutingMapper routingMapper;

    //获得所有可选品牌
    @Override
    public List<String> getBrands() {
        try {
            return mapper.getBrands();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取品牌列表失败！");
            return null;
        }
    }

    @Override
    public List<String> getSeasons() {
        try {
            return mapper.getSeasons();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取季节列表失败！");
            return null;
        }
    }

    @Override
    public List<String> getTypes() {
        try {
            return mapper.getTypes();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取产品类型列表失败！");
            return null;
        }
    }


    @Override
    public List<String> getStyleByBrand(String brand) {
        try {
            return mapper.getStyleByBrand(brand);
        }catch (Exception e){
            System.out.println("根据品牌获取样式列表失败！");
            return null;
        }
    }

    @Override
    public List<String> getColorByBrandStyle(String brand, String style) {
        try {
            return mapper.getColorByBrandStyle(brand,style);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("根据品牌样式获取颜色列表失败！");
            return null;
        }
    }

    @Override
    public ArrayList<HashMap<String,Object> > getRoutingInfosByID(String routing_id) {
        try {
            List<QueryRoutingProcedureVo> list = routingMapper.getRoutingInfosByID(routing_id);
            ArrayList<HashMap<String,Object> > data = new ArrayList<>();
            int order = 1;
            for(QueryRoutingProcedureVo item:list){
                HashMap<String,Object> procedure = new HashMap<>();
                procedure.put("procedure_id",item.getProcedure_id());
                procedure.put("name",item.getName());
                procedure.put("order",order++);
                data.add(procedure);
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("根据工艺路线id获得工艺路线具体信息失败！");
            return null;
        }
    }

    //获得所有可选颜色
    @Override
    public List<String> getColors() {
        try {
            return mapper.getColors();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取颜色列表失败！");
            return null;
        }
    }

    //获得所有可选型号
    @Override
    public List<String> getSizes() {
        try {
            return mapper.getSizes();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取型号列表失败！");
            return null;
        }
    }

    //获得所有可选工序
    @Override
    public List<String> getProcedures() {
        try {
            return mapper.getProcedures();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取工序列表失败！");
            return null;
        }
    }

    //获得该公司所有可选工序
    @Override
    public List<String> getProceduresByCompany(String company_id) {
        try {
            return mapper.getProceduresByCompany(company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取工序列表失败！");
            return null;
        }
    }

    //获得所有物料名称
    private List<String> getMaterials(){
        try {
            return mapper.getMaterials();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<String> getMaterialsByCompany(String company_id){
        try {
            return mapper.getMaterialsByCompany(company_id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //根据物料名称获得可选型号
    private List<String> getSizeByName(String name){
        try {
            return mapper.getSizeByName(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //根据物料名称、型号获得可选颜色
    private List<String> getColorByNameSize(String name, String size){
        try {
            return mapper.getColorByNameSize(name,size);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //获得物料信息，三级下拉框
    @Override
    public List<OptionMaterial> getOptionMaterial(){
        try {
            ArrayList<OptionMaterial> optionMaterials = new ArrayList<>();
            for(String name:getMaterials()){
                ArrayList<OptionSize> optionSizes = new ArrayList<>();
                for(String size:getSizeByName(name)){
                    OptionSize optionSize = new OptionSize(size);
                    optionSizes.add(optionSize);
                }
                OptionMaterial optionMaterial = new OptionMaterial(name,optionSizes);
                optionMaterials.add(optionMaterial);
            }

            //System.out.println(optionMaterials);
            return optionMaterials;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取物料信息三级下拉框失败！");
            return null;
        }
    }

    @Override
    public List<OptionMaterial> getOptionMaterialByCompany(String company_id) {
        try {
            ArrayList<OptionMaterial> optionMaterials = new ArrayList<>();
            //该公司的物料
            for(String name:getMaterialsByCompany( company_id)){
                ArrayList<OptionSize> optionSizes = new ArrayList<>();
                for(String size:getSizeByName(name)){
                    OptionSize optionSize = new OptionSize(size);
                    optionSizes.add(optionSize);
                }
                OptionMaterial optionMaterial = new OptionMaterial(name,optionSizes);
                optionMaterials.add(optionMaterial);
            }
            return optionMaterials;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取物料信息三级下拉框失败！");
            return null;
        }
    }

    @Override
    public List<String> getProductByCompanyID(String company_id){
        try {
            return mapper.getProductByCompanyID(company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取产品信息下拉框失败！");
            return null;
        }
    }

    @Override
    public List<String> getCompanyIDs(){
        try {
            return mapper.getCompanyIDs();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取公司款项下拉框失败！");
            return null;
        }
    }



}
