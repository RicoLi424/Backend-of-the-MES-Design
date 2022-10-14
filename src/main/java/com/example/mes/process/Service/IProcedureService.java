package com.example.mes.process.Service;

import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProcedureVo.DeleteProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.InsertProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.QueryProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.UpdateProcedureVo;

import java.util.HashMap;
import java.util.List;

public interface IProcedureService {

    //查询所有的工序信息
    HashMap<String,Object> getProceduresInfo(PageVo pageVo,int company_id);
    //根据工序id查询工序信息
    QueryProcedureVo getProcedureInfoByID(String procedure_id,int company_id);
    //增加一道工序，is_deleted默认为0
    public String addProcedure(InsertProcedureVo insertProcedureVo);
    //根据updateProcedureVo的procedure_id更新工序信息，将会同步更新modified_time与modified_by
    public String updateProcedureByID(UpdateProcedureVo updateProcedureVo);
    //根据deleteProcedureVo的procedure_id，将is_deleted设置为1，逻辑删除，将会同步更新modified_time与modified_by
    public String deleteProcedureByID(DeleteProcedureVo deleteProcedureVo);

    public List<QueryProcedureVo> getProceduresInfoByName(String name,int company_id);

    int getCount(int company_id);

    int getIndex(int company_id);

}
