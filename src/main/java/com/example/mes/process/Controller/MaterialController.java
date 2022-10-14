package com.example.mes.process.Controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.IMaterialService;
import com.example.mes.process.Vo.MaterialVo.*;
import com.example.mes.process.Vo.PageVo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/process")
public class MaterialController {

    @Autowired
    IMaterialService service;

    @GetMapping("/getTemplateMaterials")
    public String getTemplateMaterials(String company_id){
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<TemplateMaterialVo> materials = service.getTemplateMaterials(company_id);
            //data.put("count",count);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询物料信息失败");
            return "";
        }
    }

    @GetMapping("/getTemplateMaterialByID")
    public String getTemplateMaterialByID(String company_id,String material_id){
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<TemplateMaterialVo> materials = service.getTemplateMaterialByID(company_id,material_id);
            //data.put("count",count);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询物料信息失败");
            return "";
        }
    }

    //增加一个模板物料
    @PostMapping("/addTemplateMaterial")
    public String addTemplateMaterial(@RequestBody TemplateMaterialVo templateMaterialVo){
        try {

            return service.addTemplateMaterialVo(templateMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加物料失败");
            return "添加失败";
        }
    }
    //根据物料id删除一个模板物料
    @PostMapping("/deleteTemplateMaterial")
    public String deleteTemplateMaterial(@RequestBody TemplateMaterialVo templateMaterialVo){
        try {

            return service.deleteTemplateMaterialByName(templateMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除物料失败");
            return "删除失败";
        }
    }

    //修改一个物料，status与comments
    @PostMapping("/updateTemplateMaterial")
    public String updateTemplateMaterial(@RequestBody TemplateMaterialVo templateMaterialVo){
        try {

            return service.updateMaterial(templateMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新物料失败");
            return "更新失败";
        }
    }

    //从物料表material中查询全部物料信息，id、name、size、color、comments、status
    @GetMapping("/getMaterials")
    public String getMaterials(int pageOffset,int pageSize,Integer company_id){
        try {
            PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            int count = service.getCount();
            List<QueryMaterialVo> materials = service.getMaterials(pageVo,company_id);
            data.put("count",count);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询物料信息失败");
            return "";
        }
    }

    //跟据物料id查询对应物料的信息
    @GetMapping("/getMaterialByID")
    public String getMaterialByID(String material_id,int company_id){
        try {
            return JSON.toJSONString(service.getMaterialByID(material_id,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据id查询物料信息失败");
            return "";
        }
    }

    @GetMapping("/getMaterialByName")
    public String getMaterialByName(String name,String company_id){
        try {
            HashMap<String,Object> data = new HashMap<>();
            List<QueryMaterialVo> materials = service.getMaterialByName(name,company_id);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据name查询物料信息失败");
            return "";
        }
    }
    //增加一个物料
    @PostMapping("/addMaterial")
    public String addMaterial(@RequestBody InsertMaterialVo insertMaterialVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            insertMaterialVo.setMaterial_id(service.getIndex()+1+"");
            insertMaterialVo.setCreated_time(timestamp);
            insertMaterialVo.setStatus(status);
            return service.addMaterial(insertMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加物料失败");
            return "添加失败";
        }
    }

    //根据物料id删除一个物料
    @PostMapping("/deleteMaterialByID")
    public String deleteMaterialByID(@RequestBody DeleteMaterialVo deleteMaterialVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            deleteMaterialVo.setModified_time(timestamp);
            return service.deleteMaterialByID(deleteMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除物料失败");
            return "删除失败";
        }
    }

    //修改一个物料，status与comments
    @PostMapping("/updateMaterialByID")
    public String updateMaterialByID(@RequestBody UpdateMaterialVo updateMaterialVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            updateMaterialVo.setModified_time(timestamp);
            return service.updateMaterialByID(updateMaterialVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新物料失败");
            return "更新失败";
        }
    }

    @GetMapping("/getMaterialStock")
    public String getMaterialStock(int pageOffset,int pageSize,Integer company_id){
        try {
            List<QueryMaterialVo> list = service.getMaterials(new PageVo(pageOffset,pageSize),company_id);
            ArrayList<HashMap<String,Object> > materials = new ArrayList<>();
            for(QueryMaterialVo queryMaterialVo:list){
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("id",queryMaterialVo.getMaterial_id());
                hashMap.put("name",queryMaterialVo.getName());
                hashMap.put("size",queryMaterialVo.getSize());
                hashMap.put("color",queryMaterialVo.getColor());
                hashMap.put("balance",pageOffset);
                materials.add(hashMap);
            }
            HashMap<String,Object> data = new HashMap<>();
            data.put("count",20);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/getMaterialStockByInfo")
    public String getMaterialStockByInfo(String name,String size,String color){
        try {
            System.out.println(name+size+color);
            return "0";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println();
            return "0";
        }
    }
}
