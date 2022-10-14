package com.example.mes.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mes.system.entity.Access;
import com.example.mes.system.mapper.AccessMapper;
import com.example.mes.system.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl extends ServiceImpl<AccessMapper, Access> implements AccessService {
    @Autowired
    AccessMapper accessMapper;

    @Override
    public String getPermission(Integer id) {
        return accessMapper.getPermission(id);
    }

    @Override
    public List<String> getAccessName(String permission) {
        return accessMapper.getAccessNames(permission);
    }

    @Override
    public List<String> getAccessKey(List<String> access_name) {
        return accessMapper.getAccessKeys(access_name);
    }
}
