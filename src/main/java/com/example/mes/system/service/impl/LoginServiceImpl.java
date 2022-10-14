package com.example.mes.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.mes.system.entity.User;
import com.example.mes.system.entity.Vo.LoginVo;
import com.example.mes.system.mapper.LoginMapper;
import com.example.mes.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    LoginMapper loginMapper;

    @Override
    public String getPermissionName(String roleName,Integer company_id) {
        return loginMapper.getPermissionName(roleName,company_id);
    }

    @Override
    public List<String> getAccessName(String permissionName,Integer company_id) {
        return loginMapper.getAccessName(permissionName,company_id);
    }

    @Override
    public User login(LoginVo loginVo)
    {
        return loginMapper.getUser(loginVo);
    }
}
