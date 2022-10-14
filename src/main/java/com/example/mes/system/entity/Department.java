package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Department implements Serializable {
    @TableId(value = "department_name")
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
    private Integer company_id;
}
