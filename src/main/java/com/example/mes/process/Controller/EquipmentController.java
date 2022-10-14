package com.example.mes.process.Controller;


import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.IEquipmentService;
import com.example.mes.process.Vo.EquipmentVo.*;
import com.example.mes.process.Vo.MaterialVo.QueryMaterialVo;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.PageVo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/process")
public class EquipmentController {

    @Autowired
    IEquipmentService service;

    @GetMapping("/getTemplateEquipments")
    public String getTemplateEquipments(String company_id){
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<TemplateEquipmentVo> equipments = service.getTemplateEquipments(company_id);
            //data.put("count",count);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询设备信息失败");
            return "";
        }
    }

    @GetMapping("/getTemplateEquipmentByID")
    public String getTemplateEquipmentByID(String company_id,String equipment_id){
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<TemplateEquipmentVo> equipments = service.getTemplateEquipmentByID(company_id,equipment_id);
            //data.put("count",count);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询设备信息失败");
            return "";
        }
    }



    @PostMapping("/addTemplateEquipment")
    public String addTemplateEquipment(@RequestBody TemplateEquipmentVo templateEquipmentVo){
        try {

            return service.addTemplateEquipmentVo(templateEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加设备失败");
            return "添加失败";
        }
    }

    @PostMapping("/deleteTemplateEquipment")
    public String deleteTemplateEquipment(@RequestBody TemplateEquipmentVo templateEquipmentVo){
        try {

            return service.deleteTemplateEquipmentByName(templateEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除设备失败");
            return "删除失败";
        }
    }

    @PostMapping("/updateTemplateEquipment")
    public String updateTemplateEquipment(@RequestBody TemplateEquipmentVo templateEquipmentVo){
        try {

            return service.updateEquipment(templateEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新设备失败");
            return "更新失败";
        }
    }


    @GetMapping("/getEquipments")
    public String getEquipments(int pageOffset,int pageSize,int company_id){
        try {
            HashMap<String,Object> data = new HashMap<>();
            List<QueryEquipmentVo> equipments = service.getEquipments(new PageVo(pageOffset,pageSize),company_id);
            int count = service.getCount();
            data.put("count",count);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:查询设备信息列表失败！");
            return "";
        }
    }

    @GetMapping("/getEquipmentByID")
    public String getEquipmentByID(String equipment_id,int company_id){
        try {
            return JSON.toJSONString(service.getEquipmentByID(equipment_id,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据设备编号获取设备信息失败！");
            return "";
        }
    }

    @PostMapping("/addEquipment")
    public String addEquipment(@RequestBody InsertEquipmentVo insertEquipmentVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            insertEquipmentVo.setEquipment_id(service.getIndex()+1+"");
            insertEquipmentVo.setCreated_time(timestamp);
            insertEquipmentVo.setStatus(status);
            return service.addEquipment(insertEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:增加设备失败！");
            return "添加失败";
        }
    }

    @PostMapping("/deleteEquipmentByID")
    public String deleteEquipmentByID(@RequestBody DeleteEquipmentVo deleteEquipmentVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            deleteEquipmentVo.setModified_time(timestamp);
            return service.deleteEquipmentByID(deleteEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除设备失败！");
            return "删除失败";
        }
    }

    @PostMapping("/updateEquipmentByID")
    public String updateEquipmentByID(@RequestBody UpdateEquipmentVo updateEquipmentVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            updateEquipmentVo.setModified_time(timestamp);
            return service.updateEquipmentByID(updateEquipmentVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新设备信息失败！");
            return "更新失败";
        }
    }

    @GetMapping("/getEquipmentByName")
    public String getEquipmentByName(String name,String company_id){
        try {
            HashMap<String,Object> data = new HashMap<>();
            List<QueryEquipmentVo> equipments = service.getEquipmentByName(name,company_id);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:设备信息失败");
            return "";
        }
    }

}
