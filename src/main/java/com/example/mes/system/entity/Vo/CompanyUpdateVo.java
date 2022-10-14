package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CompanyUpdateVo {
    private String company_name;
    private Integer company_id;
    private String mail;
    private Timestamp created_time;
    private String status;
    private String is_deleted;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;
    private String request;
    private User user;
}
