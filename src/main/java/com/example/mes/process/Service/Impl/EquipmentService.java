package com.example.mes.process.Service.Impl;

import com.example.mes.process.Entity.TemplateEquipment;
import com.example.mes.process.Entity.TemplateMaterial;
import com.example.mes.process.Mapper.EquipmentMapper;
import com.example.mes.process.Service.IEquipmentService;
import com.example.mes.process.Vo.EquipmentVo.*;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.template.entity.EquipmentTemplate;
import com.example.mes.template.vo.EquipmentTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired(required = false)
    EquipmentMapper mapper;

    @Override
    public List<TemplateEquipmentVo> getTemplateEquipments(String company_id) {
        try {
            HashMap<Integer, TemplateEquipmentVo> map = new HashMap<>();//结果
            List<TemplateEquipment> list = mapper.getTemplateEquipments(company_id);//数据库记录列表

            for(TemplateEquipment m : list) {
                HashMap<String,String> attribute=new HashMap<>();

                if(map.containsKey(m.getEquipment_id())){
                    map.get(m.getEquipment_id()).getAttribute().put(m.getAttribute(),m.getAttribute_value());
                }else{
                    attribute = new HashMap<>();
                    TemplateEquipmentVo t =new TemplateEquipmentVo();
                    t.setEquipment_id(m.getEquipment_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().put(m.getAttribute(),m.getAttribute_value());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getEquipment_id(),t);
                }
                attribute.put(m.getAttribute(),m.getAttribute_value());



            }
            List<TemplateEquipmentVo> templateEquipmentVos =new ArrayList(map.values());



            return templateEquipmentVos;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板设备信息失败！");
            return null;
        }
    }

    @Override
    public List<TemplateEquipmentVo> getTemplateEquipmentByID(String company_id, String equipment_id) {
        try {
            HashMap<Integer, TemplateEquipmentVo> map = new HashMap<>();//结果
            List<TemplateEquipment> list = mapper.getTemplateEquipmentsByID(company_id,equipment_id);//数据库记录列表
            for(TemplateEquipment m : list) {
                HashMap<String,String> attribute=new HashMap<>();

                if(map.containsKey(m.getEquipment_id())){
                    map.get(m.getEquipment_id()).getAttribute().put(m.getAttribute(),m.getAttribute_value());
                }else{
                    attribute = new HashMap<>();
                    TemplateEquipmentVo t =new TemplateEquipmentVo();
                    t.setEquipment_id(m.getEquipment_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().put(m.getAttribute(),m.getAttribute_value());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getEquipment_id(),t);
                }
                attribute.put(m.getAttribute(),m.getAttribute_value());



            }
            List<TemplateEquipmentVo> templateEquipmentVos =new ArrayList(map.values());



            return templateEquipmentVos;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板设备信息失败！");
            return null;
        }
    }

    @Override
    public String addTemplateEquipmentVo(TemplateEquipmentVo templateEquipmentVo) {
        try {

            for(String attribute : templateEquipmentVo.getAttribute().keySet()){

                TemplateEquipment templateEquipment = new TemplateEquipment();
                templateEquipment.setEquipment_id(templateEquipmentVo.getEquipment_id());
                templateEquipment.setAttribute(attribute);
                templateEquipment.setAttribute_value(templateEquipmentVo.getAttribute().get(attribute));
                templateEquipment.setCompany_id(templateEquipmentVo.getCompany_id());
                templateEquipment.setName(templateEquipmentVo.getName());

//                System.out.println(materialTemplate.getMaterial_id());
//                System.out.println(materialTemplate.getName());
                mapper.addTemplateEquipment(templateEquipment);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public String deleteTemplateEquipmentByName(TemplateEquipmentVo templateEquipmentVo) {
        try {

            mapper.deleteTemplateEquipmentByName(templateEquipmentVo.getName(),Integer.toString(templateEquipmentVo.getCompany_id()));

            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public String updateEquipment(TemplateEquipmentVo templateEquipmentVo) {
        try {

            mapper.deleteTemplateEquipmentByName(templateEquipmentVo.getName(),Integer.toString(templateEquipmentVo.getCompany_id()));

            for(String attribute : templateEquipmentVo.getAttribute().keySet()){

                TemplateEquipment templateEquipment = new TemplateEquipment();
                templateEquipment.setEquipment_id(templateEquipmentVo.getEquipment_id());
                templateEquipment.setAttribute(attribute);
                templateEquipment.setAttribute_value(templateEquipmentVo.getAttribute().get(attribute));
                templateEquipment.setCompany_id(templateEquipmentVo.getCompany_id());
                templateEquipment.setName(templateEquipmentVo.getName());

//                System.out.println(materialTemplate.getMaterial_id());
//                System.out.println(materialTemplate.getName());
                mapper.addTemplateEquipment(templateEquipment);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public List<QueryEquipmentVo> getEquipments(PageVo pageVo,int company_id) {
        try {
            return mapper.getEquipments(pageVo,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:获取设备信息列表失败！");
            return null;
        }

    }

    @Override
    public QueryEquipmentVo getEquipmentByID(String equipment_id,int company_id) {
        try {
            return mapper.getEquipmentByID(equipment_id, company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据设备编号获得设备信息失败！");
            return null;
        }
    }

    @Override
    public String addEquipment(InsertEquipmentVo insertEquipmentVo) {
        try {
            //用于检验用户权限
            String operator_id = insertEquipmentVo.getOperator_id();
            //return "无权限";
            if (mapper.checkDuplicate(insertEquipmentVo.getName(),insertEquipmentVo.getPurpose(),insertEquipmentVo.getCompany_id())!=0){
                return "添加失败";
            }
            return mapper.addEquipment(insertEquipmentVo)?"添加成功":"添加失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:增加设备失败！");
            return "添加失败";
        }
    }

    @Override
    public String deleteEquipmentByID(DeleteEquipmentVo deleteEquipmentVo) {
        try {
            //用于检验用户权限
            String operator_id = deleteEquipmentVo.getOperator_id();
            //return "无权限";
            return mapper.deleteEquipmentByID(deleteEquipmentVo)?"删除成功":"删除失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除设备失败！");
            return "删除失败";
        }
    }

    @Override
    public String updateEquipmentByID(UpdateEquipmentVo updateEquipmentVo) {
        try {
            //用于检验用户权限
            String operator_id = updateEquipmentVo.getOperator_id();
            //return "无权限";
            return mapper.updateEquipmentByID(updateEquipmentVo)?"更新成功":"更新失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新设备失败！");
            return "更新失败";
        }
    }

    @Override
    public int getCount(){
        return mapper.getCount();
    }

    @Override
    public int getIndex() {
        return mapper.getIndex();
    }

    @Override
    public List<QueryEquipmentVo> getEquipmentByName(String name,String company_id) {
        try {
            return mapper.getEquipmentByName(name, company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据设备编号获得设备信息失败！");
            return null;
        }
    }
}
