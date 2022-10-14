package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ApplySelectVo {
    private String filter_created_name;
    private Integer filter_transfer_id;
    private List<String> status;
    private Integer pageSize;
    private Integer pageNum;
    private String sort;
    private String sortMethod;
    private User user;

}
