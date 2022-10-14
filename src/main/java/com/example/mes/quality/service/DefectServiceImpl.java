package com.example.mes.quality.service;

import com.example.mes.quality.bean.DefectBean;
import com.example.mes.quality.mapper.DefectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    DefectMapper defectMapper;

    @Override
    public List<DefectBean> getAllDefect(String company_id) {
        return defectMapper.getInfo(company_id);
    }

    @Override
    public List<DefectBean> getSearchDefect(String keyword,String company_id) {
        return defectMapper.getByDefectTypeOrCode(keyword,company_id);
    }

    @Override
    public List<DefectBean> getDefectByClassification(String keyword,String company_id) {
        return defectMapper.getByClassification(keyword,company_id);
    }

    @Override
    public List<DefectBean> getDefectTypeAndCode(String company_id) {
        return defectMapper.getTypeAndCode(company_id);
    }

    @Override
    public void deleteByCode(String defectCode,String company_id) {
        defectMapper.deleteByCode(defectCode,company_id);
    }

    @Override
    public void addDefect(DefectBean defectBean) {
        defectMapper.addDefect(defectBean);
    }
}
