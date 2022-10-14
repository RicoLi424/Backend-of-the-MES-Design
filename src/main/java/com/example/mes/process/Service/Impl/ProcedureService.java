package com.example.mes.process.Service.Impl;

import com.example.mes.process.Mapper.ProcedureMapper;
import com.example.mes.process.Service.IProcedureService;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProcedureVo.DeleteProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.InsertProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.QueryProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.UpdateProcedureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class ProcedureService implements IProcedureService {

    @Autowired(required = false)
    ProcedureMapper mapper;

    //查询所有的工序信息
    @Override
    public HashMap<String,Object> getProceduresInfo(PageVo pageVo,int company_id) {
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("count",mapper.getCount(company_id));
            map.put("procedures",mapper.getProceduresInfo(pageVo,company_id));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:查询工序信息失败！");
            return null;
        }
    }

    //根据工序id查询工序信息
    @Override
    public QueryProcedureVo getProcedureInfoByID(String procedure_id,int company_id) {
        try {
            return mapper.getProcedureInfoByID(procedure_id, company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:根据id查询工序信息失败！");
            return null;
        }
    }

    //增加一道工序，is_deleted默认为0
    @Override
    public String addProcedure(InsertProcedureVo insertProcedureVo) {
        try {
            //用于检验用户权限
            String operator_id = insertProcedureVo.getOperator_id();
            //return "无权限";
            return mapper.addProcedure(insertProcedureVo)?"添加成功":"添加失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:添加工序失败！");
            return "添加失败";
        }
    }

    //根据updateProcedureVo的procedure_id更新工序信息，将会同步更新modified_time与modified_by
    @Override
    public String updateProcedureByID(UpdateProcedureVo updateProcedureVo) {
        try {
            //用于检验用户权限
            String operator_id = updateProcedureVo.getOperator_id();
            //return "无权限";
            return mapper.updateProcedureByID(updateProcedureVo)?"更新成功":"更新失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:工序更新失败！");
            return "更新失败";
        }
    }
    //根据deleteProcedureVo的procedure_id，将is_deleted设置为1，逻辑删除，将会同步更新modified_time与modified_by
    @Override
    public String deleteProcedureByID(DeleteProcedureVo deleteProcedureVo) {
        try {
            //用于检验用户权限
            String operator_id = deleteProcedureVo.getOperator_id();
            //return "无权限";
            return mapper.deleteProcedureByID(deleteProcedureVo)?"删除成功":"删除失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:删除工序失败！");
            return "删除失败";
        }
    }

    @Override
    public int getCount(int company_id){
        return mapper.getCount(company_id);
    }

    @Override
    public int getIndex(int company_id) {
        return mapper.getIndex(company_id);
    }

    @Override
    public List<QueryProcedureVo> getProceduresInfoByName(String name, int company_id) {
        try{
            return mapper.getProceduresInfoByName(name, company_id);
        }catch (Exception e){
            System.out.println("getProceduresInfoByName service error");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            return null;
        }
    }
}
