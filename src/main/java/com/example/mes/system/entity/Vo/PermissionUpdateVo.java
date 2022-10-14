package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class PermissionUpdateVo {
    private List<String> accessList;
    private String permission_name;
    private String request;
    private User user;
}
