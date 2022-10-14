package com.example.mes.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mes.system.entity.Company;
import com.example.mes.system.entity.Vo.CompanySelectVo;
import com.example.mes.system.entity.Vo.CompanyUpdateVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService extends IService<Company> {

    public List<Company> queryCompanyList(CompanySelectVo compaySelectVo);

    public Integer getLastCount();

    public void companyDelete(Company company, int Handler);

    public Company companyFind(CompanyUpdateVo companyUpdateVo);

    public void companyUpdate(CompanyUpdateVo compayUpdateVo);

    public void companyInsert(CompanyUpdateVo compayUpdateVo);

    public Company mailFind(String mail);
    public Company companyNameFind(String company_name);
    public Company companyIdFind(Integer company_id);
    public Company getLastData();

}
