package com.example.mes.process.Service;

import com.example.mes.process.Vo.OptionsVo.OptionMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IOptionsService {

    //获得所有可选品牌
    List<String> getBrands();
    //
    List<String> getSeasons();
    //
    List<String> getTypes();
    //获得所有可选颜色
    List<String> getColors();
    //获得所有可选型号
    List<String> getSizes();
    //获得所有可选工序
    List<String> getProcedures();
    //获得所有可选工序
    List<String> getProceduresByCompany(String company_id);
    //获取物料信息
    List<OptionMaterial> getOptionMaterial();

    List<OptionMaterial> getOptionMaterialByCompany(String company_id);

    List<String> getStyleByBrand(String brand);

    List<String> getColorByBrandStyle(String brand,String style);

    ArrayList<HashMap<String,Object> > getRoutingInfosByID(String routing_id);

    //此处是公司款号  不是本公司id
    List<String> getProductByCompanyID(String company_id);

    List<String> getCompanyIDs();



}
