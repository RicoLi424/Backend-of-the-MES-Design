package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Role;
import com.example.mes.system.entity.Vo.RoleSelectVo;
import com.example.mes.system.entity.Vo.RoleUpdateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> queryRoleList(@Param("roleSelectVo") RoleSelectVo roleSelectVo, @Param("numStart") int numStart, @Param("numEnd") int numEnd);

    Integer getLastCount();

    List<String> queryAllPermissionName(Integer company_id);

    void roleDelete(@Param("role") Role role);

    Role roleFind(@Param("role_name") String role_name,@Param("company_id") Integer company_id);

    void roleUpdate(@Param("n") RoleUpdateVo roleUpdateVo);

    void roleInsert(@Param("n") RoleUpdateVo roleUpdateVo);

    List<String> getRoles(@Param("company_id") String company_id);

    void updateDepartmentName(@Param("role_name") String role_name, @Param("company_id") String company_id, @Param("department_name") String department_name);
    List<String> getRolesByDepartment(@Param("department_name") String department_name, @Param("company_id") String company_id);

    List<Role> getDefaultRole();

//    List<String> findRoleNameByDepartment(@Param("department_name") String department_name, @Param("company_id") String company_id);
}
