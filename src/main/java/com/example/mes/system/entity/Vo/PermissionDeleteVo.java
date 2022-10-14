package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class PermissionDeleteVo {
    private List<String> permissionList;
    private User user;
}
