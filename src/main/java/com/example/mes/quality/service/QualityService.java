package com.example.mes.quality.service;

import com.example.mes.quality.bean.QualityBean;

import java.util.List;


public interface QualityService {

    void addResults(QualityBean qualityBean);
    List<QualityBean> getResults(String company_id);
    List<QualityBean> queryResultByList(String list_id);
    List<QualityBean> getResultsByDate(String[] list);
    List<QualityBean> getResultsByWorkshop(String[] list);
    List<QualityBean> getResultsByDefectTypePart(String[] list);
    List<QualityBean> getResultsByDefectType(String[] list);
    List<String> getDefectCode(List<String> list,String company_id);
}
