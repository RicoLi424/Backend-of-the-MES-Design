package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Role;
import com.example.mes.system.entity.Vo.RoleSelectVo;
import com.example.mes.system.entity.Vo.RoleUpdateVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService extends IService<Role> {
    public List<Role> queryRoleList(RoleSelectVo roleSelectVo);

    public Integer getLastCount();

    public List<String> queryAllPermissionName(Integer company_id);

    public void roleDelete(Role role, int Handler);

    public Role roleFind(RoleUpdateVo roleUpdateVo);

    public void roleUpdate(RoleUpdateVo roleUpdateVo);

    void roleInsert(RoleUpdateVo roleUpdateVo);

    List<String> getRoles(String company_id);

    List<String> getRolesByDepartment(String department_name, String company_id);

    void setDefaultRole(Integer user_id, Integer company_id);

//    List<String> findRoleNameByDepartment(String filter_department_name, Integer company_id);
}
