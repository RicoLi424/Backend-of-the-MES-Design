package com.example.mes.system.controller;

import com.example.mes.system.entity.Vo.PermissionDeleteVo;
import com.example.mes.system.entity.Vo.PermissionSelectVo;
import com.example.mes.system.entity.Vo.PermissionUpdateVo;
import com.example.mes.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data/permissionManagement/")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @PostMapping("/permissionList")
    public Object queryPermissionList(
            @RequestBody PermissionSelectVo permissionSelectVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<HashMap<String, Object>> temp = new ArrayList<>();


        List<String> permission_name = permissionService.findByName(permissionSelectVo);
        int permissionListCount = permissionService.getLastCount(permissionSelectVo.getUser().getCompany_id());
        int size = permission_name.size();
        for (int i = 0; i < size; i++) {
            HashMap<String, Object> f = new HashMap<>();
            List<String> accessList = permissionService.findAccessName(permission_name.get(i),permissionSelectVo.getUser().getCompany_id());
            f.put("permission_name", permission_name.get(i));
            f.put("accessList", accessList);
            temp.add(i, f);
        }


        List<String> accessName = permissionService.findAllAccessName();
        res.put("permissionList", temp);
        res.put("total", permissionListCount);
        res.put("accessList", accessName);
        MyUtils.success(res);


        return res;
    }

    @PostMapping("/permissionDelete")
    public Object permissionDelete(

            @RequestBody PermissionDeleteVo permissionDeleteVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        List<String> permissionList = permissionDeleteVo.getPermissionList();
        for (String permissionName : permissionList) {
            permissionService.permissionDelete(permissionName,permissionDeleteVo.getUser().getId());
        }
        MyUtils.success(res);
        return res;

    }

    @PostMapping("/permissionUpdate")
    public Object permissionUpdate(
            @RequestBody PermissionUpdateVo permissionUpdateVo
    ) {
        HashMap<String, Object> res = new HashMap<>();
        String name = permissionService.permissionFind(permissionUpdateVo);
        if (permissionUpdateVo.getRequest().equals("update")) {
            if (name == null) {
                MyUtils.fail(res, "此权限不存在，请先创建该权限");
            } else {

                permissionService.permissionAllDelete(permissionUpdateVo);
                permissionService.permissionUpdate(permissionUpdateVo);
                MyUtils.success(res);
            }
        }

        if (permissionUpdateVo.getRequest().equals("insert")) {
            if (name != null) {
                MyUtils.fail(res, "该权限已经存在，请勿重复创建");
            } else {
                permissionService.permissionInsert(permissionUpdateVo);
                MyUtils.success(res);
            }
        }


        return res;
    }
}
