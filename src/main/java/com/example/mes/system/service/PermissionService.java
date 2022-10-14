package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Permission;
import com.example.mes.system.entity.Vo.PermissionSelectVo;
import com.example.mes.system.entity.Vo.PermissionUpdateVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService extends IService<Permission> {
    List<String> findByName(PermissionSelectVo permissionSelectVo);

    List<String> findAccessName(String permission_name,Integer company_id);

    int getLastCount(Integer company_id);

    List<String> findAllAccessName();

    void permissionDelete(String permissionName, int handler);

    String permissionFind(PermissionUpdateVo permissionUpdateVo);

    void permissionUpdate(PermissionUpdateVo permissionUpdateVo);

    void permissionInsert(PermissionUpdateVo permissionUpdateVo);

    void permissionAllDelete(PermissionUpdateVo permissionUpdateVo);

    void setDefaultPermission(Integer user_id, Integer company_id);
}
