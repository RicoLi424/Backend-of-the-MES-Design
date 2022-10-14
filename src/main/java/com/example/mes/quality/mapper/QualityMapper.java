package com.example.mes.quality.mapper;

import com.example.mes.quality.bean.QualityBean;

import java.util.List;


public interface QualityMapper {

    void addQualityResults(QualityBean qualityBean);
    List<QualityBean> getQualityResults(String company_id);
    List<QualityBean> getQualityResultsByDate(String[] list);
    List<QualityBean> getQualityResultsByWorkshop(String[] list);
    List<QualityBean> getQualityResultsByDefectTypePart(String[] list);
    List<QualityBean> getQualityResultsByDefectType(String[] list);
    List<QualityBean> queryResultByList(String list_id);
    List<String> getDefectCode(List<String> list,String company_id);
}
