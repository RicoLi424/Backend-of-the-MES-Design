package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Department;
import com.example.mes.system.entity.Vo.DepartmentCountVo;
import com.example.mes.system.entity.Vo.DepartmentSelectVo;
import com.example.mes.system.entity.Vo.DepartmentUpdateVo;
import com.example.mes.system.entity.Vo.newDepartmentUpdateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> queryDepartmentList(@Param("DepartmentSelectVo") DepartmentSelectVo departmentSelectVo, @Param("numStart") int numStart, @Param("numEnd") int numEnd);

    int getLastCount(Integer company_id);

    void departmentDelete(@Param("department") Department department);

    Department departmentFind(String department_name);

    void departmentUpdate(@Param("n") DepartmentUpdateVo departmentUpdateVo);

    void departmentInsert(@Param("n") DepartmentUpdateVo departmentUpdateVo);

    List<DepartmentCountVo> getDepartmentCount(Integer company_id);

    Department newdepartmentFind(@Param("department_name") String department_name, @Param("company_id") String company_id);

    void newdepartmentInsert(@Param("n") newDepartmentUpdateVo newdepartmentUpdateVo);

    void newdepartmentUpdate(@Param("n") newDepartmentUpdateVo newdepartmentUpdateVo);

    List<Department> getDefaultDepartment();
}
