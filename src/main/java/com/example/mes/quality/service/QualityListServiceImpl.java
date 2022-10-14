package com.example.mes.quality.service;

import com.example.mes.quality.bean.QualityListBean;
import com.example.mes.quality.bean.Vo.QualityListVo;
import com.example.mes.quality.mapper.QualityListMapper;
import com.example.mes.system.service.impl.MyImplUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityListServiceImpl implements QualityListService {

    @Autowired
    QualityListMapper qualitylistMapper;

    @Override
    public List<QualityListBean> queryAll() {
        return qualitylistMapper.selectAll();
    }

    @Override
    public List<QualityListBean> querylistByStatus() {
        return qualitylistMapper.selectListByStatus();
    }

    @Override
    public List<QualityListBean> querylistByLine() {
        return qualitylistMapper.selectListByLine();
    }

    @Override
    public List<QualityListBean> querylistByWorkShop() {
        return qualitylistMapper.selectListByWorkShop();
    }

    @Override
    public Integer queryListNum() {
        return qualitylistMapper.selectListNum();
    }

    @Override
    public List<QualityListBean> queryQualityList(QualityListVo qualityListVo) {
        int numStart = MyImplUtils.getNumStart(qualityListVo.getPageNum(), qualityListVo.getPageSize());
        int numEnd = MyImplUtils.getNumEnd(qualityListVo.getPageSize());
        return qualitylistMapper.queryQualityList(qualityListVo, numStart, numEnd);
    }

    @Override
    public Integer getLastCount(QualityListVo qualityListVo) {
        return qualitylistMapper.getLastCount(qualityListVo);
    }

    @Override
    public QualityListBean queryQualityByList(String list_id,String company_id) {
        return  qualitylistMapper.queryQualityByListID(list_id,company_id);
    }

    @Override
    public void updateQualityListStatus(String list_id,String company_id) {
        qualitylistMapper.updateQualityListStatus(list_id,company_id);
    }

    @Override
    public List<String> getAllWorkshop(String company_id) {
        try {
            return qualitylistMapper.getAllWorkshop(company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取车间列表失败！");
            return null;
        }
    }


    @Override
    public List<String> getAllLine(String company_id) {
        try {
            return qualitylistMapper.getAllLine(company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取产线列表失败！");
            return null;
        }
    }

    @Override
    public List<String> getAllLinesByWorkshop(String workshop_id,String company_id) {
        try {
            return qualitylistMapper.getAllLinesByWorkshop(workshop_id,company_id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取产线列表失败！");
            return null;
        }
    }

//    @Override
//    public List<QualityListBean> getPlanList(Integer company_id) {
//        return qualitylistMapper.getPlanList2(company_id);
//    }
//
//    @Override
//    public List<String> getListId(Integer company_id) {
//        return qualitylistMapper.getListId(company_id);
//    }
//
//    @Override
//    public void insertQuality(QualityListBean list, Integer company_id) {
//        qualitylistMapper.insertQuality(list,company_id);
//    }


}
