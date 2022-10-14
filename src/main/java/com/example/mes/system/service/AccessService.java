package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Access;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccessService extends IService<Access> {
    String getPermission(Integer id);

    List<String> getAccessName(String permission);

    List<String> getAccessKey(@Param("access_names") List<String> access_name);
}
