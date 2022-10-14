package com.example.mes.dataAnalysis.Mapper;

import com.example.mes.dataAnalysis.Vo.IDPair;
import com.example.mes.dataAnalysis.Vo.MaterialStock;
import com.example.mes.dataAnalysis.Vo.MaterialStockChange;
import com.example.mes.process.Vo.PageVo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface DataAnalysisMapper {


    //根据完成日期，获得客户需求单号
    List<String> getDemandFormNosByDate(@Param("date") String date,String company_id);
    //跟据客户需求单号，获得需求单号，获得需求单中的产品合对应的生产订单
    List<IDPair> getIDPairs(@Param("no") String no);
    //根据需求单号，获得该需求单号的完成情况
    int getProducedQuantity(@Param("demand_form_id") String demand_form_id);

    int getDemandQuantity(@Param("demand_form_id") String demand_form_id);

    //根据计划单号，获得该产品的计划单完成情况
    List<Integer> getPlanProducedQuantity(@Param("plan_id") String plan_id);

   List <Integer> getPlanDemandQuantity(@Param("plan_id") String plan_id);
    //根据需求单号，获得对应的计划单号
    List<String> getDemandPlanId(@Param("demand_form_id") String demand_form_id);
    //根据产品号，获得对应的计划单号
    List<String> getPlanProductId(@Param("product_id") String product_id);
    //getPlanByProductId
    List<String> getPlanProductno(@Param("product_id")String product_id);
    String getProductNameByID(@Param("product_id") String product_id);


    //获得库存信息
    List<MaterialStock> getMaterialStock(@Param("pageVo") PageVo pageVo, @Param("company_id")String company_id);
    int getCount(@Param("company_id")String company_id);
    //根据物料id获得物料库存信息
    MaterialStock getMaterialStockByID(@Param("material_id") String material_id);
    //根据物料信息获取物料id
    String getMaterialIDByInfo(@Param("name") String name, @Param("size") String size);
    //
    MaterialStock getMaterialInfoByID(@Param("material_id") String material_id, @Param("company_id")String company_id);

    List<MaterialStockChange> getMaterialStockChanges(@Param("material_id") String material_id);

    boolean addMaterialStockChanges(@Param("materialStockChange") MaterialStockChange materialStockChange);

    List<String> getMaterialIDs();
    //获取过程单信息的相关方法
    List<String> getProcessPlanId(String plan_id);

    List<Integer> getProcessProducedQuantity(String process_id);


    List<Integer> getProcessDemandQuantity(String process_id);


    List<String> getProcessPlanName(String plan_id);
}
