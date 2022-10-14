package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;

import java.sql.Timestamp;

public class UserUpdateVo {
    public Integer id;
    public String name;
    public int age;
    public int sex;
    public String pwd;
    public String department;
    public String user_name;
    public String role;
    public Integer company_id;
    public Timestamp created_time;
    public String status;
    public String is_deleted;
    public String created_by;
    public Timestamp modified_time;
    public String modified_by;
    public String request;
    public Integer isChangeDepartment;
    public User user;
}
