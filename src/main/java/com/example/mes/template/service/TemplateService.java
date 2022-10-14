package com.example.mes.template.service;

import com.example.mes.process.Entity.TemplateMaterial;
import com.example.mes.process.Vo.MaterialVo.DeleteMaterialVo;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.MaterialVo.UpdateMaterialVo;

import com.example.mes.process.Vo.OptionsVo.OptionMaterial;
import com.example.mes.template.entity.EquipmentTemplate;
import com.example.mes.template.entity.MaterialTemplate;
import com.example.mes.template.mapper.TemplateMapper;
import com.example.mes.template.vo.EquipmentTemplateVO;
import com.example.mes.template.vo.MaterialTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class TemplateService implements TemplateServiceImpl{

    @Autowired
    private TemplateMapper templateMapper;

    public List<MaterialTemplateVo> getAllMaterial(String company_id) {

            try {
                HashMap<Integer,MaterialTemplateVo> map = new HashMap<>();//结果
                List<MaterialTemplate> list = templateMapper.getInfo(company_id);//数据库记录列表

                for(MaterialTemplate m : list) {
                    ArrayList<String> attribute=new ArrayList<>();

                    if(map.containsKey(m.getMaterial_id())){
                        map.get(m.getMaterial_id()).getAttribute().add(m.getAttribute());
                    }else{
                        attribute = new ArrayList<>();
                        MaterialTemplateVo t =new MaterialTemplateVo();
                        t.setId(m.getMaterial_id());
                        t.setName(m.getName());
                        t.setAttribute(attribute);
                        t.getAttribute().add(m.getAttribute());
                        t.setCompany_id(m.getCompany_id());
                        map.put(m.getMaterial_id(),t);
                        //attribute.add(m.getAttribute());
                    }




                }
                List<MaterialTemplateVo> materialTemplateVo =new ArrayList(map.values());
                //System.out.println(materialTemplateVo.get(0));
                return materialTemplateVo;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("service：查询模板物料信息失败！");
                return null;
            }
    }

    @Override
    public List<MaterialTemplateVo> getMaterialTemplateByName(String name,String company_id) {
        try {
            HashMap<Integer,MaterialTemplateVo> map = new HashMap<>();//结果
            List<MaterialTemplate> list = templateMapper.selectMaterialTemplateByName(name,company_id);//数据库记录列表

            for(MaterialTemplate m : list) {
                ArrayList<String> attribute=new ArrayList<>();

                if(map.containsKey(m.getMaterial_id())){
                    map.get(m.getMaterial_id()).getAttribute().add(m.getAttribute());
                }else{
                    attribute = new ArrayList<>();
                    MaterialTemplateVo t =new MaterialTemplateVo();
                    t.setId(m.getMaterial_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().add(m.getAttribute());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getMaterial_id(),t);
                }
                //attribute.add(m.getAttribute());



            }
            List<MaterialTemplateVo> materialTemplateVo =new ArrayList(map.values());

            return materialTemplateVo;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板物料信息失败！");
            return null;
        }
    }

    @Override
    public List<MaterialTemplate> getMaterialTemplateByID(int material_id,String company_id) {
        return templateMapper.selectMaterialTemplateById(material_id,company_id);
    }

    //增加
    @Transactional
    @Override
    public String addMaterialTemplate(MaterialTemplateVo materialTemplateVo) {
        try {

            if (templateMapper.countMaterialId(materialTemplateVo.getId(),materialTemplateVo.getCompany_id())!=0){
                return "id_error";

            }

            for(String attribute : materialTemplateVo.getAttribute()){

                MaterialTemplate materialTemplate = new MaterialTemplate();
                materialTemplate.setMaterial_id(materialTemplateVo.getId());
                materialTemplate.setCompany_id(materialTemplateVo.getCompany_id());
                materialTemplate.setAttribute(attribute);
                materialTemplate.setName(materialTemplateVo.getName());
//                System.out.println(materialTemplate.getMaterial_id());
//                System.out.println(materialTemplate.getName());
                templateMapper.addMaterialTemplate(materialTemplate);
            }
            return "yes";

            }catch (Exception e){
            e.printStackTrace();

            return "no";
        }

    }

    //删除
    @Override
    public String deleteMaterialTemplate(MaterialTemplateVo materialTemplateVo) {
        try {

                templateMapper.deleteMaterialTemplateByName(materialTemplateVo.getName(),Integer.toString(materialTemplateVo.getCompany_id()));

            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }

    }

    //更新模板
    @Transactional
    @Override
    public String updateMaterialTemplate(MaterialTemplateVo materialTemplateVo) {
        try {

            templateMapper.deleteMaterialTemplateByName(materialTemplateVo.getName(),Integer.toString(materialTemplateVo.getCompany_id()));


            for(String attribute : materialTemplateVo.getAttribute()){

                MaterialTemplate materialTemplate = new MaterialTemplate();
                materialTemplate.setMaterial_id(materialTemplateVo.getId());
                materialTemplate.setCompany_id(materialTemplateVo.getCompany_id());
                materialTemplate.setAttribute(attribute);
                materialTemplate.setName(materialTemplateVo.getName());
                templateMapper.addMaterialTemplate(materialTemplate);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }


    /*
    以下为设备模板的service
     */
    @Override
    public List<EquipmentTemplateVO> getAllEquipment(String company_id) {
        try {
            HashMap<Integer,EquipmentTemplateVO> map = new HashMap<>();//结果
            List<EquipmentTemplate> list = templateMapper.getEquipmentInfo(company_id);//数据库记录列表

            for(EquipmentTemplate m : list) {
                ArrayList<String> attribute=new ArrayList<>();

                if(map.containsKey(m.getEquipment_id())){
                    map.get(m.getEquipment_id()).getAttribute().add(m.getAttribute());
                }else{
                    attribute = new ArrayList<>();
                    EquipmentTemplateVO t =new EquipmentTemplateVO();
                    t.setId(m.getEquipment_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().add(m.getAttribute());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getEquipment_id(),t);
                }
            }
            List<EquipmentTemplateVO> equipmentTemplateVO =new ArrayList(map.values());

            return equipmentTemplateVO;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板设备信息失败！");
            return null;
        }
    }

    @Override
    public List<EquipmentTemplateVO> getEquipmentTemplateByName(String name,String company_id) {
        try {
            HashMap<Integer,EquipmentTemplateVO> map = new HashMap<>();//结果
            List<EquipmentTemplate> list = templateMapper.selectEquipmentTemplateByName(name,company_id);//数据库记录列表
            for(EquipmentTemplate m : list) {
                ArrayList<String> attribute=new ArrayList<>();

                if(map.containsKey(m.getEquipment_id())){
                    map.get(m.getEquipment_id()).getAttribute().add(m.getAttribute());
                }else{
                    attribute = new ArrayList<>();
                    EquipmentTemplateVO t =new EquipmentTemplateVO();
                    t.setId(m.getEquipment_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().add(m.getAttribute());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getEquipment_id(),t);
                }
            }
            List<EquipmentTemplateVO> equipmentTemplateVO =new ArrayList(map.values());
            return equipmentTemplateVO;
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("service：查询模板设备信息失败！");
        return null;
    }
    }

    @Override
    public List<EquipmentTemplateVO> getEquipmentTemplateByID(int equipment_id,String company_id) {
        try {
            HashMap<Integer,EquipmentTemplateVO> map = new HashMap<>();//结果
            List<EquipmentTemplate> list = templateMapper.selectEquipmentTemplateById(equipment_id,company_id);//数据库记录列表

            for(EquipmentTemplate m : list) {
                ArrayList<String> attribute=new ArrayList<>();

                if(map.containsKey(m.getEquipment_id())){
                    map.get(m.getEquipment_id()).getAttribute().add(m.getAttribute());
                }else{
                    attribute = new ArrayList<>();
                    EquipmentTemplateVO t =new EquipmentTemplateVO();
                    t.setId(m.getEquipment_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().add(m.getAttribute());
                    t.setCompany_id(m.getCompany_id());
                    map.put(m.getEquipment_id(),t);
                }
            }
            List<EquipmentTemplateVO> equipmentTemplateVO =new ArrayList(map.values());

            return equipmentTemplateVO;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板设备信息失败！");
            return null;
        }
    }

    @Transactional
    @Override
    public String addEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO){
        try {

            templateMapper.deleteEquipmentTemplateByName(equipmentTemplateVO.getName(),Integer.toString(equipmentTemplateVO.getCompany_id()));


            for(String attribute : equipmentTemplateVO.getAttribute()){

                EquipmentTemplate equipmentTemplate = new EquipmentTemplate();
                equipmentTemplate.setEquipment_id(equipmentTemplateVO.getId());
                equipmentTemplate.setCompany_id(equipmentTemplateVO.getCompany_id());
                equipmentTemplate.setAttribute(attribute);
                equipmentTemplate.setName(equipmentTemplateVO.getName());
                templateMapper.addEquipmentTemplate(equipmentTemplate);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public String deleteEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO) {
        try {

            templateMapper.deleteEquipmentTemplateByName(equipmentTemplateVO.getName(),Integer.toString(equipmentTemplateVO.getCompany_id()));

            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }

    }

    @Transactional
    @Override
    public String updateEquipmentTemplate(EquipmentTemplateVO equipmentTemplateVO) {
        try {

            templateMapper.deleteEquipmentTemplateByName(equipmentTemplateVO.getName(),Integer.toString(equipmentTemplateVO.getCompany_id()));


            for(String attribute : equipmentTemplateVO.getAttribute()){

                EquipmentTemplate equipmentTemplate = new EquipmentTemplate();
                equipmentTemplate.setEquipment_id(equipmentTemplateVO.getId());
                equipmentTemplate.setCompany_id(equipmentTemplateVO.getCompany_id());
                equipmentTemplate.setAttribute(attribute);
                equipmentTemplate.setName(equipmentTemplateVO.getName());
                templateMapper.addEquipmentTemplate(equipmentTemplate);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }





}
