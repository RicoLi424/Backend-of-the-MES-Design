package com.example.mes.process.Mapper;

import com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo;
import com.example.mes.process.Vo.ProductVo.DeleteProductVo;
import com.example.mes.process.Vo.ProductVo.InsertProductVo;
import com.example.mes.process.Vo.ProductVo.UpdateProductVo;
import com.example.mes.process.Vo.RoutingVo.DeleteRoutingVo;
import com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo;
import com.example.mes.process.Vo.RoutingVo.InsertRoutingVo;
import com.example.mes.process.Vo.RoutingVo.UpdateRoutingVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface TransactionMapper {

    //增加物料清单
    boolean addProMaterialLists(@Param("list") ArrayList<InsertProMaterialVo> insertProMaterialVos);
    //删除物料清单（用于修改前的删除，再重新插入，作为修改
    boolean deleteProMaterialLists(@Param("product_id") String product_id);
    //增加一个产品的概述信息
    boolean addProduct(@Param("insertProductVo") InsertProductVo insertProductVo);
    //逻辑删除一个产品
    boolean deleteProductByID(@Param("deleteProductVo") DeleteProductVo deleteProductVo);
    //修改一个产品，可修改status与comments
    boolean updateProductByID(@Param("updateProductVo") UpdateProductVo updateProductVo);
    //逻辑删除工艺路线
    boolean deleteRoutingByID(@Param("deleteRoutingVo") DeleteRoutingVo deleteRoutingVo);
    //插入工艺路线概要信息
    boolean addRouting(@Param("insertRoutingVo") InsertRoutingVo insertRoutingVo);
    //插入工艺路线具体信息
    boolean addRoutingInfos(@Param("list")ArrayList<InsertRoutingProcedureVo> list);

    //更新工艺路线信息，可以更新status跟comments
    boolean updateRoutingByID(@Param("updateRoutingVo") UpdateRoutingVo updateRoutingVo);
    //删除联系表中的工艺路线与工序的记录，用于更新
    boolean deleteRoutingProcedureByID(@Param("routing_id") String routing_id);

}
