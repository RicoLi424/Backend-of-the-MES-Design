package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Company implements Serializable {
    private Integer id;
    @TableId(value = "company_name")
    private String company_name;
    private Integer company_id;
    private String mail;
    private Timestamp created_time;
    private String status;
    private String is_deleted;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;


}
