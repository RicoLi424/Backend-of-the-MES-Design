package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private int age;
    private int sex;
    private String pwd;
    private String department;
    private String user_name;
    private String role;
    private Timestamp created_time;
    private String status;
    private String is_deleted;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;
    private Integer company_id;


    public User() {
    }

    public User(Integer id, String name, int age, int sex, String pwd,String department, String user_name, String role, Timestamp created_time, String status, String is_deleted, String created_by, Timestamp modified_time, String modified_by, Integer company_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pwd = pwd;
        this.company_id = company_id;
        this.department = department;
        this.user_name = user_name;
        this.role = role;
        this.created_time = created_time;
        this.status = status;
        this.is_deleted = is_deleted;
        this.created_by = created_by;
        this.modified_time = modified_time;
        this.modified_by = modified_by;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}
