package com.example.mes.system.controller;

import com.example.mes.system.entity.Vo.AccessVo;
import com.example.mes.system.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/innerAccess/")
public class AccessController {
    @Autowired
    AccessService accessService;

    @PostMapping("/access")
    public Boolean accessJudge(
            @RequestBody AccessVo accessVo
    ) {
        Integer id = accessVo.getId();
        String access_key = accessVo.getAccess_key();
        String permission = accessService.getPermission(id);
        List<String> access_name = accessService.getAccessName(permission);
        List<String> accessKey = accessService.getAccessKey(access_name);
        return accessKey.contains(access_key);
    }
}
