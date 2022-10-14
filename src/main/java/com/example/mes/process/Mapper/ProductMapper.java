package com.example.mes.process.Mapper;

import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProductVo.DeleteProductVo;
import com.example.mes.process.Vo.ProductVo.InsertProductVo;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;
import com.example.mes.process.Vo.ProductVo.UpdateProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    //查询所有的产品概述
    List<QueryProductVo> getProducts(@Param("pageVo") PageVo pageVo);
    //查询所有的产品概述
    List<QueryProductVo> getProductsByCompany(@Param("pageVo") PageVo pageVo,@Param("company_id")String company_id);
    //根据id查询产品概述
    QueryProductVo getProductByID(@Param("product_id") String product_id);
    //增加一个产品的概述信息
    boolean addProduct(@Param("insertProductVo") InsertProductVo insertProductVo);
    //逻辑删除一个产品
    boolean deleteProductByID(@Param("deleteProductVo") DeleteProductVo deleteProductVo);
    //修改一个产品，可修改status与comments
    boolean updateProductByID(@Param("updateProductVo") UpdateProductVo updateProductVo);
    //查询记录条数
    int getCount();
    //test
    List<String> getProductIdsByDate(@Param("date") String date);

    int checkDuplicate(@Param("name") String name,@Param("brand") String brand,
                       @Param("style") String style,@Param("color") String color);

    List<QueryProductVo> getProductsByCompanyAndType(@Param("pageVo")PageVo pageVo, @Param("company_id")String company_id, @Param("type")String type);

    List<QueryProductVo> getProductsByCompanyAndCompany(@Param("pageVo")PageVo pageVo, @Param("company_id")String company_id,@Param("company")String company);
}
