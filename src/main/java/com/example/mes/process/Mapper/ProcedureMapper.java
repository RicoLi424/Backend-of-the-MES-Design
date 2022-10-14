package com.example.mes.process.Mapper;

import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProcedureVo.DeleteProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.InsertProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.QueryProcedureVo;
import com.example.mes.process.Vo.ProcedureVo.UpdateProcedureVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProcedureMapper {

    //查询所有的工序信息
    List<QueryProcedureVo> getProceduresInfo(@Param("pageVo") PageVo pageVo,@Param("company_id") int company_id);
    //根据工序id查询工序信息
    QueryProcedureVo getProcedureInfoByID(@Param("procedure_id") String procedure_id,@Param("company_id") int company_id);
    //增加一道工序，is_deleted默认为0
    public boolean addProcedure(@Param("insertProcedureVo") InsertProcedureVo insertProcedureVo);
    //根据updateProcedureVo的procedure_id更新工序信息，将会同步更新modified_time与modified_by
    public boolean updateProcedureByID(@Param("updateProcedureVo") UpdateProcedureVo updateProcedureVo);
    //根据deleteProcedureVo的procedure_id，将is_deleted设置为1，逻辑删除，将会同步更新modified_time与modified_by
    public boolean deleteProcedureByID(@Param("deleteProcedureVo") DeleteProcedureVo deleteProcedureVo);
    //获取记录数
    int getCount(@Param("company_id") int company_id);

    int getIndex(@Param("company_id") int company_id);

    public List<QueryProcedureVo> getProceduresInfoByName(@Param("name") String name,@Param("company_id") int company_id);

}
