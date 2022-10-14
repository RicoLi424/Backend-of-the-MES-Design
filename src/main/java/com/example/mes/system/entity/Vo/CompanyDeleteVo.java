package com.example.mes.system.entity.Vo;

import com.example.mes.system.entity.Company;
import com.example.mes.system.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDeleteVo {
    private List<Company> companyList;
    private User user;
}
