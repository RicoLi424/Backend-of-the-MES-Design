package com.example.mes.process.Service.Impl;

import com.example.mes.process.Entity.TemplateMaterial;
import com.example.mes.process.Mapper.MaterialMapper;
import com.example.mes.process.Service.IMaterialService;
import com.example.mes.process.Vo.MaterialVo.*;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.template.entity.MaterialTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MaterialService implements IMaterialService {

    @Autowired(required = false)
    MaterialMapper mapper;

    @Override
    public List<TemplateMaterialVo> getTemplateMaterials(String company_id) {
        try {
            HashMap<Integer,TemplateMaterialVo> map = new HashMap<>();//结果
            List<TemplateMaterial> list = mapper.getTemplateMaterials(company_id);//数据库记录列表

            for(TemplateMaterial m : list) {
                HashMap<String,String> attribute=new HashMap<>();

                if(map.containsKey(m.getMaterial_id())){
                    map.get(m.getMaterial_id()).getAttribute().put(m.getAttribute(),m.getAttribute_value());
                }else{
                    attribute = new HashMap<>();
                    TemplateMaterialVo t =new TemplateMaterialVo();
                    t.setMaterial_id(m.getMaterial_id());
                    t.setName(m.getName());
                    t.setAttribute(attribute);
                    t.getAttribute().put(m.getAttribute(),m.getAttribute_value());
                    map.put(m.getMaterial_id(),t);
                }
                attribute.put(m.getAttribute(),m.getAttribute_value());



            }
            List<TemplateMaterialVo> templateMaterialVo =new ArrayList(map.values());

            return templateMaterialVo;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板物料信息失败！");
            return null;
        }
    }

    @Override
    public List<TemplateMaterialVo> getTemplateMaterialByID(String company_id, String material_id) {
        try {

                HashMap<Integer,TemplateMaterialVo> map = new HashMap<>();//结果
                List<TemplateMaterial> list = mapper.getTemplateMaterialByID(company_id,material_id);//数据库记录列表

                for(TemplateMaterial m : list) {
                    HashMap<String,String> attribute=new HashMap<>();

                    if(map.containsKey(m.getMaterial_id())){
                        map.get(m.getMaterial_id()).getAttribute().put(m.getAttribute(),m.getAttribute_value());
                    }else{
                        attribute = new HashMap<>();
                        TemplateMaterialVo t =new TemplateMaterialVo();
                        t.setMaterial_id(m.getMaterial_id());
                        t.setName(m.getName());
                        t.setAttribute(attribute);
                        t.getAttribute().put(m.getAttribute(),m.getAttribute_value());
                        map.put(m.getMaterial_id(),t);
                    }
                    attribute.put(m.getAttribute(),m.getAttribute_value());



                }
                List<TemplateMaterialVo> templateMaterialVo =new ArrayList(map.values());

                return templateMaterialVo;


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询模板物料信息失败！");
            return null;
        }
    }

    //增加模板物料
    @Override
    public String addTemplateMaterialVo(TemplateMaterialVo templateMaterialVo) {
        try {

            for(String attribute : templateMaterialVo.getAttribute().keySet()){

                TemplateMaterial templateMaterial = new TemplateMaterial();
                templateMaterial.setMaterial_id(templateMaterialVo.getMaterial_id());
                templateMaterial.setAttribute(attribute);
                templateMaterial.setAttribute_value(templateMaterialVo.getAttribute().get(attribute));
                templateMaterial.setCompany_id(templateMaterialVo.getCompany_id());
                templateMaterial.setName(templateMaterialVo.getName());

//                System.out.println(materialTemplate.getMaterial_id());
//                System.out.println(materialTemplate.getName());
                mapper.addTemplateMaterial(templateMaterial);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public String deleteTemplateMaterialByName(TemplateMaterialVo templateMaterialVo) {
        try {

                mapper.deleteTemplateMaterialByName(templateMaterialVo.getName(),Integer.toString(templateMaterialVo.getCompany_id()));

            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    @Override
    public String updateMaterial(TemplateMaterialVo templateMaterialVo) {
        try {

            mapper.deleteTemplateMaterialByName(templateMaterialVo.getName(),Integer.toString(templateMaterialVo.getCompany_id()));

            for(String attribute : templateMaterialVo.getAttribute().keySet()){

                TemplateMaterial templateMaterial = new TemplateMaterial();
                templateMaterial.setMaterial_id(templateMaterialVo.getMaterial_id());
                templateMaterial.setAttribute(attribute);
                templateMaterial.setAttribute_value(templateMaterialVo.getAttribute().get(attribute));
                templateMaterial.setCompany_id(templateMaterialVo.getCompany_id());
                templateMaterial.setName(templateMaterialVo.getName());

//                System.out.println(materialTemplate.getMaterial_id());
//                System.out.println(materialTemplate.getName());
                mapper.addTemplateMaterial(templateMaterial);
            }
            return "yes";

        }catch (Exception e){
            e.printStackTrace();

            return "no";
        }
    }

    //从物料表material中查询全部物料信息，id、name、size、color、comments、status
    @Override
    public List<QueryMaterialVo> getMaterials(PageVo pageVo,Integer company_id) {
        try {
            return mapper.getMaterials(pageVo,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service：查询物料信息失败！");
            return null;
        }
    }

    //跟据物料id查询对应物料的信息
    @Override
    public QueryMaterialVo getMaterialByID(String material_id,int company_id) {
        try {
            return mapper.getMaterialByID(material_id,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据id查询物料信息失败");
            return null;
        }
    }
    @Override
    public List<QueryMaterialVo> getMaterialByName(String name,String company_id) {
        try {
            return mapper.getMaterialByName(name,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据id查询物料信息失败");
            return null;
        }
    }

    //增加一个物料
    @Override
    public String addMaterial(InsertMaterialVo insertMaterialVo) {
        try {
            //用于检验用户权限
            String operator_id = insertMaterialVo.getOperator_id();
            //return "无权限";
            if (mapper.check(insertMaterialVo.getName(),insertMaterialVo.getSize())!=0){
                return "添加失败";
            }

            return mapper.addMaterial(insertMaterialVo)?"添加成功":"添加失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:增加物料失败！");
            return "添加失败";
        }
    }

    //根据物料id删除一个物料
    @Override
    public String deleteMaterialByID(DeleteMaterialVo deleteMaterialVo) {
        try {
            //用于检验用户权限
            String operator_id = deleteMaterialVo.getOperator_id();
            //return "无权限";
            return mapper.deleteMaterialByID(deleteMaterialVo)?"删除成功":"删除失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:删除物料失败");
            return "删除失败";
        }
    }

    //修改一个物料，status与comments
    @Override
    public String updateMaterialByID(UpdateMaterialVo updateMaterialVo) {
        try {
            //用于检验用户权限
            String operator_id = updateMaterialVo.getOperator_id();
            //return "无权限";
            return mapper.updateMaterialByID(updateMaterialVo)?"更新成功":"更新失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:更新物料失败");
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

}
