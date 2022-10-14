package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Apply {
    @TableId(value = "log_id",type = IdType.AUTO)
    private Integer log_id;
    private Integer transfer_id;
    private String from_department;
    private String to_department;
    private String to_role;
    private String status;
    private String is_deleted;
    private Timestamp created_time;
    private String created_by;
    private Timestamp handled_time;
    private String handled_by;
    private Integer company_id;
}
