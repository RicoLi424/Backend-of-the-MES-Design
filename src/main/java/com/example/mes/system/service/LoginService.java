package com.example.mes.system.service;

import com.example.mes.system.entity.User;
import com.example.mes.system.entity.Vo.LoginVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface LoginService {
    User login(LoginVo loginVo);
    String getPermissionName(String roleName, Integer company_id);

    List<String> getAccessName(String permissionName, Integer company_id);

}
