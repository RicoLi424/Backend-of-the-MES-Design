package com.example.mes.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mes.system.entity.Company;
import com.example.mes.system.entity.Vo.CompanySelectVo;
import com.example.mes.system.entity.Vo.CompanyUpdateVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper extends BaseMapper<Company> {
    List<Company> queryCompanyList(@Param("companySelectVo") CompanySelectVo companySelectVo, @Param("numStart") int numStart, @Param("numEnd") int numEnd);

    Integer getLastCount();

    void companyDelete(@Param("company") Company company);

    Company companyFind(@Param("company_name") String company_name, @Param("company_id") Integer company_id, @Param("mail") String mail);

    void companyUpdate(@Param("n") CompanyUpdateVo companyUpdateVo);

    void companyInsert(@Param("n") CompanyUpdateVo companyUpdateVo);

    //额外添加几个方法，用于判断正误
    //用于查找当前邮箱是否已注册公司
    Company mailFind(@Param("mail") String mail);

    //用于查找当前名称是否已被使用
    Company companyNameFind(@Param("company_name") String company_name);

    //用于查找当前id是否已被使用
    Company companyIdFind(@Param("company_id") Integer company_id);
    //用于查询最后一条数据
    Company getLastData();

}

