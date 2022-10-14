package com.example.mes.template.controller;
import com.alibaba.fastjson.JSON;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.quality.bean.DefectBean;
import com.example.mes.template.entity.EquipmentTemplate;
import com.example.mes.template.entity.MaterialTemplate;
import com.example.mes.template.service.TemplateService;
import com.example.mes.template.vo.EquipmentTemplateVO;
import com.example.mes.template.vo.MaterialTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @CrossOrigin
    @GetMapping("/material/all")  //全部物料模板信息 格式在下方注释
    public Object materialAll(String company_id) throws Exception {

        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<MaterialTemplateVo> materials = templateService.getAllMaterial(company_id);
            //data.put("count",count);
            data.put("materials",materials);
//            System.out.println(materials);
//            System.out.println(JSON.toJSONString(data));
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询物料信息失败");
            return "";
        }
//        List<MaterialTemplate> materialTemplate = templateService.getAllMaterial(company_id);
//        HashMap<String,Object> map = new HashMap<>();

//
//        //id与上一记录不一样就是另一模板，清空list重新加入key value
//        for(MaterialTemplate t : materialTemplate) {
//            List<String> lst;
//            if(map.containsKey(t.getName())){
//                lst = (List<String>) map.get(t.getName());
//            }else{
//                lst = new LinkedList<>();
//            }
//            lst.add(t.getAttribute());
//            map.put(t.getName(),lst);
//        }
//
//
//        return map;
    }

    @CrossOrigin
    @GetMapping("/material/getMaterialTemplateByName")  //全部物料模板信息 格式在下方注释
    public Object getMaterialTemplateByName(String name,String company_id) throws Exception {

        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<MaterialTemplateVo> materials = templateService.getMaterialTemplateByName(name,company_id);
            //data.put("count",count);
            data.put("materials",materials);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询物料信息失败");
            return "";
        }

//        List<MaterialTemplate> materialTemplate = templateService.getMaterialTemplateByName(name,company_id);
//        HashMap<String,Object> map = new HashMap<>();
//

//
//        for(MaterialTemplate t : materialTemplate) {
//            List<String> lst;
//            if(map.containsKey(t.getName())){
//                lst = (List<String>) map.get(t.getName());
//            }else{
//                lst = new LinkedList<>();
//            }
//            lst.add(t.getAttribute());
//            map.put(t.getName(),lst);
//        }
//        System.out.println(company_id);
//        return map;
    }


    @CrossOrigin
    @PostMapping("/material/addMaterialTemplate")
    public String addMaterialTemplate(@RequestBody MaterialTemplateVo materialTemplateVo) throws Exception{
         return templateService.addMaterialTemplate(materialTemplateVo);
    }

    @CrossOrigin
    @PostMapping("/material/deleteMaterialTemplate")
    public String deleteMaterialTemplate(@RequestBody MaterialTemplateVo materialTemplateVo) throws Exception{
        return templateService.deleteMaterialTemplate(materialTemplateVo);
    }
    @CrossOrigin
    @PostMapping("/material/updateMaterialTemplate")
    public String updateMaterialTemplate(@RequestBody MaterialTemplateVo materialTemplateVo) throws Exception{
        return templateService.updateMaterialTemplate(materialTemplateVo);
    }






    /*
    以下为设备模板的controller
     */

    @CrossOrigin
    @GetMapping("/equipment/all")
    public Object equipmentAll(String company_id) throws Exception {
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<EquipmentTemplateVO> equipments = templateService.getAllEquipment(company_id);
            //data.put("count",count);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询设备模板信息失败");
            return "";
        }
    }

    @CrossOrigin
    @GetMapping("/equipment/getEquipmentTemplateByName")  //全部物料模板信息 格式在下方注释
    public Object getEquipmentTemplateByName(String name,String company_id) throws Exception {
        try {
            //PageVo pageVo = new PageVo(pageOffset,pageSize);
            HashMap<String,Object> data = new HashMap<>();
            //int count = service.getCount();
            List<EquipmentTemplateVO> equipments = templateService.getEquipmentTemplateByName(name,company_id);
            //data.put("count",count);
            data.put("equipments",equipments);
            return JSON.toJSONString(data);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询设备模板信息失败");
            return "";
        }
    }

    @CrossOrigin
    @PostMapping("/equipment/addEquipmentTemplate")
    public String addEquipmentTemplate(@RequestBody EquipmentTemplateVO equipmentTemplateVO) throws Exception{
        return templateService.addEquipmentTemplate(equipmentTemplateVO);
    }

    @CrossOrigin
    @PostMapping("/equipment/deleteEquipmentTemplate")
    public String deleteEquipmentTemplate(@RequestBody EquipmentTemplateVO equipmentTemplateVO) throws Exception{
        return templateService.deleteEquipmentTemplate(equipmentTemplateVO);
    }

    @CrossOrigin
    @PostMapping("/equipment/updateEquipmentTemplate")
    public String updateEquipmentTemplate(@RequestBody EquipmentTemplateVO equipmentTemplateVO) throws Exception{
        return templateService.updateEquipmentTemplate(equipmentTemplateVO);
    }



}
