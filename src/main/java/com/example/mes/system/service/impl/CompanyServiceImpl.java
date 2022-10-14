package com.example.mes.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mes.system.entity.Company;
import com.example.mes.system.entity.Vo.CompanySelectVo;
import com.example.mes.system.entity.Vo.CompanyUpdateVo;
import com.example.mes.system.mapper.CompanyMapper;
import com.example.mes.system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> queryCompanyList(CompanySelectVo companySelectVo) {
        int numStart = MyImplUtils.getNumStart(companySelectVo.pageNum, companySelectVo.pageSize);
        int numEnd = MyImplUtils.getNumEnd(companySelectVo.pageSize);
        return companyMapper.queryCompanyList(companySelectVo, numStart, numEnd);
    }

    @Override
    public Integer getLastCount() {
        return companyMapper.getLastCount();
    }

    @Override
    public void companyDelete(Company company, int handler) {
        company.setModified_by(Integer.toString(handler));
        company.setModified_time(MyImplUtils.getCurrentTime());
        company.setStatus("已删除");
        companyMapper.companyDelete(company);

    }

    @Override
    public Company companyFind(CompanyUpdateVo companyUpdateVo) {
        return companyMapper.companyFind(companyUpdateVo.getCompany_name(),companyUpdateVo.getCompany_id(),companyUpdateVo.getMail());
    }

    @Override
    public void companyUpdate(CompanyUpdateVo companyUpdateVo) {
        companyUpdateVo.setModified_by(Integer.toString(companyUpdateVo.getUser().getId()));
        companyUpdateVo.setModified_time(MyImplUtils.getCurrentTime());
        companyMapper.companyUpdate(companyUpdateVo);
    }

    @Override
    public void companyInsert(CompanyUpdateVo companyUpdateVo) {
        companyUpdateVo.setCreated_time(MyImplUtils.getCurrentTime());
        companyUpdateVo.setModified_time(companyUpdateVo.getCreated_time());
        companyUpdateVo.setCreated_by(Integer.toString(100000));//默认由系统管理员安排公司的入驻
        companyUpdateVo.setModified_by(companyUpdateVo.getCreated_by());
        companyUpdateVo.setIs_deleted("0");
        companyMapper.companyInsert(companyUpdateVo);
    }

    @Override
    public Company mailFind(String mail){
        return companyMapper.mailFind(mail);
    }
    @Override
    public Company companyNameFind(String company_name){
        return companyMapper.companyNameFind(company_name);
    }

    @Override
    public Company companyIdFind(Integer company_id){
        return companyMapper.companyIdFind(company_id);
    }

    @Override
    public Company getLastData(){
        return companyMapper.getLastData();
    }

}
