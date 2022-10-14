package com.example.mes.quality.mapper;

import com.example.mes.quality.bean.DefectBean;

import java.util.List;


public interface DefectMapper {

    List<DefectBean> getInfo(String company_id);
    List<DefectBean> getByDefectTypeOrCode(String keyword,String company_id);
    List<DefectBean> getByClassification(String keyword,String company_id);
    List<DefectBean> getTypeAndCode(String company_id);
    void deleteByCode(String defectCode,String company_id);
    void addDefect(DefectBean defectBean);

}
