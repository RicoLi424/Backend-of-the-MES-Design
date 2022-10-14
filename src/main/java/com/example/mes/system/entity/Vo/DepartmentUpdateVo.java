package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DepartmentUpdateVo {
    private String department_name;
    private String manager_name;
    private int manager_id;
    private String department_describe;
    private String status;
    private String is_deleted;
    private Timestamp created_time;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;
    private String request;

    private User user;
    private String company_id;
}
