package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.Role;
import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class RoleDeleteVo {
    private List<Role> roleList;
    private User user;
}
