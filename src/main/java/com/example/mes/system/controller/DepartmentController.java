package com.example.mes.system.controller;

import com.example.mes.system.entity.Department;
import com.example.mes.system.entity.Vo.*;
import com.example.mes.system.service.DepartmentService;
import com.example.mes.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data/departmentManagement/")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    @PostMapping("/departmentList")
    public Object queryRoleList(
            @RequestBody DepartmentSelectVo departmentSelectVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> temp = new ArrayList<>();

        List<Department> departmentList = departmentService.queryDepartmentList(departmentSelectVo);
        int departmentListCount = departmentService.getLastCount(departmentSelectVo.getUser().getCompany_id());
        List<DepartmentCountVo> departmentCountVos = departmentService.getDepartmentCount(departmentSelectVo.getUser().getCompany_id());
        //查询部门对应角色
        for(int i = 0; i < departmentList.size(); i++){
            HashMap<String, Object> f = new HashMap<>();
            List<String> roleList = roleService.getRolesByDepartment(departmentList.get(i).getDepartment_name(),Integer.toString(departmentSelectVo.getUser().getCompany_id()));
            f.put("department_name", departmentList.get(i).getDepartment_name());
            f.put("manager_id",departmentList.get(i).getManager_id());
            f.put("manager_name",departmentList.get(i).getManager_name());
            f.put("department_describe",departmentList.get(i).getDepartment_describe());
            f.put("roleList", roleList);

            temp.add(i, f);
        }

        res.put("departmentCount", departmentCountVos);
        res.put("departmentList", temp);
        res.put("total", departmentListCount);
        MyUtils.success(res);
        return res;
    }

    @PostMapping("/departmentDelete")
    public Object departmentDelete(
            @RequestBody DepartmentDeleteVo departmentDeleteVo
            ) {
        HashMap<String, Object> res = new HashMap<>();
        List<Department> departmentList = departmentDeleteVo.getDepartmentList();

        for (Department department : departmentList) {

            departmentService.departmentDelete(department,departmentDeleteVo.getUser().getId(),departmentDeleteVo.getUser().getCompany_id());
        }
        MyUtils.success(res);
        return res;
    }

    @PostMapping("/departmentUpdate")
    public Object departmentUpdate(
            @RequestBody newDepartmentUpdateVo newdepartmentUpdateVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
//        Department department = departmentService.departmentFind(newdepartmentUpdateVo);
        Department department = departmentService.newdepartmentFind(newdepartmentUpdateVo);
        if (newdepartmentUpdateVo.getRequest().equals("update")) {
            if (department == null) {
                MyUtils.fail(res, "该部门不存在,无法更新");
            } else {
//                departmentService.departmentUpdate(newdepartmentUpdateVo);

                departmentService.newDepartmentUpdate(newdepartmentUpdateVo);
                MyUtils.success(res);
            }
        } else if (newdepartmentUpdateVo.getRequest().equals("insert")) {
            //增加部门
            if (department != null) {
                MyUtils.fail(res, "该部门已经存在，请勿重复创建");
            } else {
//                departmentService.departmentAdd(newdepartmentUpdateVo);
                departmentService.newDepartmentAdd(newdepartmentUpdateVo);
                MyUtils.success(res);
            }
        }


        return res;
    }


}
