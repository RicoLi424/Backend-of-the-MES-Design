package com.example.mes.process.Controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.process.Service.IProcedureService;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProcedureVo.DeleteProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.InsertProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.UpdateProcedureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
@RequestMapping("/process")
public class ProcedureController {

    @Autowired
    IProcedureService service;

    @GetMapping("/getProceduresInfo")
    public String getProceduresInfo(int pageOffset,int pageSize,int company_id){
        try {
            return JSON.toJSONString(service.getProceduresInfo(new PageVo(pageOffset,pageSize),company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:查询工序信息失败");
            return "";
        }
    }

    @GetMapping("/getProcedureInfoByID")
    public String getProcedureInfoByID(String procedure_id,int company_id){
        try {
            return JSON.toJSONString(service.getProcedureInfoByID(procedure_id,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据id查询工序信息失败");
            return "";
        }
    }

    @PostMapping("/addProcedure")
    public String addProcedure(@RequestBody InsertProcedureVo insertProcedureVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            insertProcedureVo.setProcedure_id(service.getIndex(insertProcedureVo.getCompany_id())+1+"");
            insertProcedureVo.setCreated_time(timestamp);
            insertProcedureVo.setStatus(status);
            return service.addProcedure(insertProcedureVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:添加工序失败");
            return "添加失败";
        }
    }

    @PostMapping("/deleteProcedureByID")
    public String deleteProcedureByID(@RequestBody DeleteProcedureVo deleteProcedureVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            deleteProcedureVo.setModified_time(timestamp);
            return service.deleteProcedureByID(deleteProcedureVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:删除工序失败");
            return "删除失败";
        }
    }

    @PostMapping("/updateProcedureByID")
    public String updateProcedureByID(@RequestBody UpdateProcedureVo updateProcedureVo){
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            updateProcedureVo.setModified_time(timestamp);
            return service.updateProcedureByID(updateProcedureVo);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:更新工序失败");
            return "更新失败";
        }
    }


    @GetMapping("/getProcedureInfoByName")
    public String getProcedureInfoByName(String name,int company_id){
        try {
            return JSON.toJSONString(service.getProceduresInfoByName(name,company_id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("controller:根据name查询工序信息失败");
            return "";
        }
    }
}
