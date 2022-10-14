package com.example.mes.quality.mapper;

import com.example.mes.quality.bean.QualityListBean;
import com.example.mes.quality.bean.Vo.QualityListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityListMapper {

    //查找所有质检任务
    List<QualityListBean> selectAll();

    //根据状态查询质检任务
    List<QualityListBean> selectListByStatus();

    //根据产线查询质检任务
    List<QualityListBean> selectListByLine();

    //根据车间查询质检任务
    List<QualityListBean> selectListByWorkShop();

    //某质检任务生产的产品数量
    Integer selectListNum();

    //分页
    List<QualityListBean> queryQualityList(@Param("qualityListVo") QualityListVo qualityListVo, @Param("numStart") int numStart, @Param("numEnd") int numEnd);

    Integer getLastCount(@Param("qualityListVo") QualityListVo qualityListVo);

    //根据list_id查询质检任务
    QualityListBean queryQualityByListID(@Param("list_id") String list_id,@Param("company_id") String company_id);

    //修改状态
    void updateQualityListStatus(@Param("list_id") String list_id,@Param("company_id") String company_id);

    //查询所有质检任务中的车间
    List<String> getAllWorkshop(@Param("company_id") String company_id);

    //查询所有质检任务中的产线
    List<String> getAllLine(@Param("company_id") String company_id);

    //查询车间中的产线
    List<String> getAllLinesByWorkshop(@Param("workshop_id") String workshop_id,@Param("company_id") String company_id);

//    List<QualityListBean> getPlanList2(@Param("company_id") Integer company_id);
//
//    List<String> getListId(@Param("company_id") Integer company_id);
//
//    void insertQuality(@Param("list") QualityListBean list,@Param("company_id") Integer company_id);
}
