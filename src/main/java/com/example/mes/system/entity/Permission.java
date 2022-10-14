package com.example.mes.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Permission implements Serializable {
    @TableId(value = "permission_id",type = IdType.AUTO)
    private Integer permission_id;
    private String permission_name;
    private String access_name;
    private String status;
    private String is_deleted;
    private String created_by;
    private String created_time;
    private Timestamp modified_time;
    private String modified_by;
    private Integer company_id;
}
