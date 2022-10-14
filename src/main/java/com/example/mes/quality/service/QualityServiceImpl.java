package com.example.mes.quality.service;

import com.example.mes.quality.bean.QualityBean;
import com.example.mes.quality.mapper.QualityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XiaoYu
 * @Date: 2021/07/13/12:18
 * @Description:
 */
@Service
public class QualityServiceImpl implements QualityService {

    @Autowired
    QualityMapper qualityMapper;

    @Override
    public void addResults(QualityBean qualityBean) {
        qualityMapper.addQualityResults(qualityBean);
    }

    @Override
    public List<QualityBean> getResults(String company_id) {
        return qualityMapper.getQualityResults(company_id);
    }

    @Override
    public List<QualityBean> getResultsByDate(String[] list) {
        return qualityMapper.getQualityResultsByDate(list);
    }

    @Override
    public List<QualityBean> getResultsByWorkshop(String[] list) {
        return qualityMapper.getQualityResultsByWorkshop(list);
    }

    @Override
    public List<QualityBean> getResultsByDefectTypePart(String[] list) {
        return qualityMapper.getQualityResultsByDefectTypePart(list);
    }

    @Override
    public List<QualityBean> getResultsByDefectType(String[] list) {
        return qualityMapper.getQualityResultsByDefectType(list);
    }

    @Override
    public List<String> getDefectCode(List<String> list,String company_id) {
        try {
            return qualityMapper.getDefectCode(list,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取瑕疵代号列表失败！");
            return null;
        }
    }

    @Override
    public List<QualityBean> queryResultByList(String list_id) {
        return qualityMapper.queryResultByList(list_id);
    }
}
