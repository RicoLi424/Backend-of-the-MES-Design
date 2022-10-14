package com.example.mes.process.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionsMapper {

    //获取所有可选品牌
    List<String> getBrands();
    //
    List<String> getSeasons();
    //
    List<String> getTypes();
    //获取所有可选颜色
    List<String> getColors();
    //获取所有可选型号
    List<String> getSizes();
    //获得所有可选工序
    List<String> getProcedures();
    List<String> getProceduresByCompany(@Param("company_id")String company_id);
    //获得所有物料名称
    List<String> getMaterials();

    List<String> getMaterialsByCompany(@Param("company_id")String company_id);
    //根据物料名称获得可选型号
    List<String> getSizeByName(@Param("name") String name);
    //根据物料名称、型号获得可选颜色
    List<String> getColorByNameSize(@Param("name") String name,@Param("size") String size);

    List<String> getStyleByBrand(@Param("brand") String brand);

    List<String> getColorByBrandStyle(@Param("brand") String brand,@Param("style") String style);

    //款号
    List<String> getProductByCompanyID(@Param("company") String company);

    //款号
    List<String> getCompanyIDs();



}
