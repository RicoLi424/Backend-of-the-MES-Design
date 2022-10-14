package com.example.mes.system.controller;

import com.example.mes.system.entity.User;
import com.example.mes.system.entity.Vo.LoginVo;
import com.example.mes.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("data/login/")
public class LoginController
{
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Object login(@RequestBody LoginVo loginVo)
    {
        User user = loginService.login(loginVo);
        HashMap<String, Object> res = new HashMap<>();
        if (user == null)
        {
            MyUtils.fail(res, "用户名或密码错误");
        }
        else
        {
            Integer company_id = user.getCompany_id();
            HashMap<String, Object> userinfo = new HashMap<>();
            String roleName = user.getRole();
            String permissionName = loginService.getPermissionName(roleName,company_id);
            List<String> accessList = loginService.getAccessName(permissionName,company_id);

            userinfo.put("accessList",accessList);
            userinfo.put("id", user.getId());
            userinfo.put("name", user.getName());
            userinfo.put("age", user.getAge());
            userinfo.put("sex", user.getSex());
            userinfo.put("company_id",user.getCompany_id());
            userinfo.put("username", user.getUser_name());
            userinfo.put("status", user.getStatus());

            res.put("userinfo", userinfo);
            MyUtils.success(res);
        }
        return res;
    }
}
