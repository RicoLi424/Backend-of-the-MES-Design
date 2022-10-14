package com.example.mes.system.controller;

import com.alibaba.fastjson.JSON;
import com.example.mes.system.entity.Role;
import com.example.mes.system.entity.Vo.RoleDeleteVo;
import com.example.mes.system.entity.Vo.RoleSelectVo;
import com.example.mes.system.entity.Vo.RoleUpdateVo;
import com.example.mes.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("data/roleManagement/")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/roleList")
    public Object queryRoleList(
            @RequestBody RoleSelectVo roleSelectVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<Role> roleList = roleService.queryRoleList(roleSelectVo);
        int roleListCount = roleService.getLastCount();
        List<String> allPermissionName = roleService.queryAllPermissionName(roleSelectVo.user.getCompany_id());

        res.put("roleList", roleList);
        res.put("total", roleListCount);
        res.put("permissionList", allPermissionName);
        MyUtils.success(res);
        return res;
    }

    //为角色下拉列表提供数据
    @GetMapping("/getRoles")
    public Object getRoles(@RequestParam("company_id") String company_id){
        HashMap<String, Object> res=new HashMap<>();
        try {
            res.put("roles",roleService.getRoles(company_id));
            MyUtils.success(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("角色下拉框生成失败！");
            MyUtils.fail(res,"角色下拉框生成失败！");
            return res;
        }
    }


    //根据部门显示对应的角色
    @GetMapping("/getRolesByDepartment")
    public Object getRolesByDepartment(@RequestParam("department_name") String department_name , @RequestParam("company_id") String company_id){
        HashMap<String, Object> res=new HashMap<>();
        try {
            res.put("roles",roleService.getRolesByDepartment(department_name,company_id));
            MyUtils.success(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("角色下拉框生成失败！");
            MyUtils.fail(res,"角色下拉框生成失败！");
            return res;
        }
    }


    @PostMapping("/roleDelete")
    public Object roleDelete(
            @RequestBody RoleDeleteVo roleDeleteVo
            ) {
        HashMap<String, Object> res = new HashMap<>();
        for (Role role : roleDeleteVo.getRoleList()) {
            roleService.roleDelete(role,roleDeleteVo.getUser().getId());
        }
        MyUtils.success(res);
        return res;
    }

    @PostMapping("/roleUpdate")
    public Object roleUpdate(
            @RequestBody RoleUpdateVo roleUpdateVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
//        System.out.println(roleUpdateVo.getRole_name());
//        System.out.println(roleUpdateVo.getUser().getCompany_id());
        Role role = roleService.roleFind(roleUpdateVo);
        if (roleUpdateVo.getRequest().equals("update")) {
            if (role == null) {
                MyUtils.fail(res, "该角色不存在");
            } else {
                roleService.roleUpdate(roleUpdateVo);
                MyUtils.success(res);
            }
        } else if (roleUpdateVo.getRequest().equals("insert")) {
            if (role != null) {
                MyUtils.fail(res, "该角色已经存在，请勿重复创建");
            } else {
                roleService.roleInsert(roleUpdateVo);
                MyUtils.success(res);
            }
        }

        return res;
    }
}
