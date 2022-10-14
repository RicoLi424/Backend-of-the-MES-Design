package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

@Data
public class PermissionSelectVo {
    private String filter_permission_name;
    private Integer pageSize;
    private Integer pageNum;
    private String sort;
    private String sortMethod;
    private User user;
}
