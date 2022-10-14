package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoleUpdateVo {
    private String role_name;
    private String role_id;
    private String department_name;
    private String role_describe;
    private String permission;
    private Timestamp created_time;
    private String status;
    private String is_deleted;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;
    private String request;
    private Integer company_id;
    private User user;
}
