package com.example.mes.quality.service;

import com.example.mes.quality.bean.DefectBean;

import java.util.List;


public interface DefectService {

    List<DefectBean> getAllDefect(String company_id);
    List<DefectBean> getSearchDefect(String keyword,String company_id);
    List<DefectBean> getDefectByClassification(String keyword,String company_id);
    List<DefectBean> getDefectTypeAndCode(String company_id);
    void deleteByCode(String defectCode,String company_id);
    void addDefect(DefectBean defectBean);
}
