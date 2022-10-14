package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

@Data
public class ApplyAddressVo {
    private Integer handled_id;
    private Integer apply_id;
    private String isAccept;
    private User user;
}
