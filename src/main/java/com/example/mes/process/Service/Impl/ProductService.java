package com.example.mes.process.Service.Impl;

import com.example.mes.process.Mapper.ProductMapper;
import com.example.mes.process.Mapper.RoutingMapper;
import com.example.mes.process.Service.IProductService;
import com.example.mes.process.Vo.PageVo.PageVo;
import com.example.mes.process.Vo.ProductVo.DeleteProductVo;
import com.example.mes.process.Vo.RoutingVo.DeleteRoutingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired(required = false)
    ProductMapper mapper;
    @Autowired(required = false)
    RoutingMapper rmapper;

    @Override
    public HashMap<String,Object> getProducts(PageVo pageVo) {
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("count", mapper.getCount());
            map.put("products",mapper.getProducts(pageVo));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取产品信息失败！");
            return null;
        }
    }

    @Override
    public HashMap<String,Object> getProducts(PageVo pageVo,String company_id) {
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("count", mapper.getCount());
            map.put("products",mapper.getProductsByCompany(pageVo,company_id));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取产品信息失败！");
            return null;
        }
    }

    @Override
    public HashMap<String, Object> getProducts(PageVo pageVo, String company_id, String company) {
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("count", mapper.getCount());
            map.put("products",mapper.getProductsByCompanyAndCompany(pageVo,company_id,company));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取产品信息失败！");
            return null;
        }
    }

    @Override
    public HashMap<String, Object> getProductsByType(PageVo pageVo, String company_id, String type) {
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("count", mapper.getCount());
            map.put("products",mapper.getProductsByCompanyAndType(pageVo,company_id,type));
            return map;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取产品信息失败！");
            return null;
        }
    }

    //逻辑删除产品，同步逻辑删除工艺路线
    @Transactional
    @Override
    public String deleteProductByID(DeleteProductVo deleteProductVo) {
        try {
            //用于检验用户权限
            String operator_id = deleteProductVo.getOperator_id();
            //return "无权限";
            //同时逻辑删除工艺路线，工艺路线id与产品id相同
            DeleteRoutingVo deleteRoutingVo = new DeleteRoutingVo(deleteProductVo.getProduct_id(),deleteProductVo.getOperator_id());
            //*****新增条件
            deleteRoutingVo.setCompany_id(deleteProductVo.getCompany_id());
            deleteRoutingVo.setModified_time(deleteProductVo.getModified_time());
            return mapper.deleteProductByID(deleteProductVo)&&rmapper.deleteRoutingByID(deleteRoutingVo)?"删除成功":"删除失败";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:删除产品失败！");
            return "删除失败";
        }
    }

    @Override
    public List<String> getProductIdsByDate(String date){
        try {
            return mapper.getProductIdsByDate(date);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("根据date获取产品编号失败");
            return null;
        }
    }


}
