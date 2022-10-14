package com.example.mes.system.entity.Vo;

import lombok.Data;

@Data
public class CompanySelectVo {
    public String filter_company_name;
    public Integer pageSize;
    public Integer pageNum;
    public String sort;
    public String sortMethod;

}
