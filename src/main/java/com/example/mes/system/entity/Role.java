package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Role implements Serializable {
    @TableId(value = "role_name")
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



}
