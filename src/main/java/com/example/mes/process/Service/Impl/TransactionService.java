package com.example.mes.process.Service.Impl;

import com.example.mes.process.Mapper.*;
import com.example.mes.process.Service.ITransactionService;
import com.example.mes.process.Vo.MaterialVo.QueryProMaterialVo;
import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.ProductVo.InsertProductVo;
import com.example.mes.process.Vo.ProductVo.QueryProductVo;
import com.example.mes.process.Vo.RoutingVo.InsertRoutingVo;
import com.example.mes.process.Vo.RoutingVo.QueryRoutingProcedureVo;
import com.example.mes.process.Vo.RoutingVo.QueryRoutingVo;
import com.example.mes.process.Vo.RoutingVo.UpdateRoutingVo;
import com.example.mes.process.Vo.TransactionVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class TransactionService implements ITransactionService {

    @Autowired(required = false)
    RoutingMapper routingMapper;
    @Autowired(required = false)
    MaterialMapper materialMapper;
    @Autowired(required = false)
    ProductMapper productMapper;
    @Autowired(required = false)
    NameIDMapper nameIDMapper;
    @Autowired(required = false)
    TransactionMapper mapper;

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public String add(InsertVo insertVo) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            String operator_id = insertVo.getOperator_id();
            String uuid = UUID.randomUUID().toString().replace("-","");
            //添加产品信息
            InsertProductVo product = insertVo.getProduct();
//            if (productMapper.checkDuplicate(product.getName(),product.getBrand(),product.getStyle(),product.getColor())!=0){
//                return "添加失败";
//            }
            product.setProduct_id(uuid);
            product.setCreated_time(timestamp);
            product.setOperator_id(operator_id);
            product.setStatus("正常");
            mapper.addProduct(product);
            //添加工艺路线概述信息
            InsertProcessVo process = insertVo.getProcess();
            InsertRoutingVo insertRoutingVo = new InsertRoutingVo(process.getComments(),operator_id);
            insertRoutingVo.setRouting_id(uuid);
            insertRoutingVo.setCreated_time(timestamp);
            insertRoutingVo.setStatus(status);
            //设置公司id
            insertRoutingVo.setCompany_id(product.getCompany_id());
            mapper.addRouting(insertRoutingVo);
            //添加工艺路线详细信息
            ArrayList<InsertRoutingProcedureVo> data = process.getData();
            ArrayList<com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo> insertRoutingProcedureVos = new ArrayList<>();
            int order = 1;
            for(InsertRoutingProcedureVo item:data){
                String procedure_id = nameIDMapper.getProcedureIDByName(item.getContent());
                insertRoutingProcedureVos.add(new com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo(uuid,procedure_id,order++,product.getCompany_id()));
            }
            mapper.addRoutingInfos(insertRoutingProcedureVos);

            //添加物料清单信息
            //**********此部分重构

            ArrayList<InsertProMaterialVo> material = insertVo.getMaterial();
            ArrayList<com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo> insertProMaterialVos = new ArrayList<>();
            for(InsertProMaterialVo item:material){

                String material_id = nameIDMapper.getMaterialIDByNameSizeColor(item.getName(),item.getSize());
                insertProMaterialVos.add(new com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo(uuid,material_id,item.getCount()));
            }
            mapper.addProMaterialLists(insertProMaterialVos);
            return "添加成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:添加产品详细信息失败！");
            return "添加失败";
        }
    }


    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public String add2(InsertVopro insertVopro) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            String operator_id = insertVopro.getOperator_id();
            String uuid = UUID.randomUUID().toString().replace("-","");
            //添加产品信息
            InsertProductVo product = insertVopro.getProduct();
//            if (productMapper.checkDuplicate(product.getName(),product.getBrand(),product.getStyle(),product.getColor())!=0){
//                return "添加失败";
//            }
            product.setProduct_id(uuid);
            product.setCreated_time(timestamp);
            product.setOperator_id(operator_id);
            product.setStatus("正常");
            mapper.addProduct(product);
            //添加工艺路线概述信息
            InsertProcessVo process = insertVopro.getProcess();
            InsertRoutingVo insertRoutingVo = new InsertRoutingVo(process.getComments(),operator_id);
            insertRoutingVo.setRouting_id(uuid);
            insertRoutingVo.setCreated_time(timestamp);
            insertRoutingVo.setStatus(status);
            //设置公司id
            insertRoutingVo.setCompany_id(product.getCompany_id());
            mapper.addRouting(insertRoutingVo);
            //添加工艺路线详细信息
            ArrayList<InsertRoutingProcedureVo> data = process.getData();
            ArrayList<com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo> insertRoutingProcedureVos = new ArrayList<>();
            int order = 1;
            for(InsertRoutingProcedureVo item:data){
                String procedure_id = nameIDMapper.getProcedureIDByName(item.getContent());
                insertRoutingProcedureVos.add(new com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo(uuid,procedure_id,order++,product.getCompany_id()));
            }
            mapper.addRoutingInfos(insertRoutingProcedureVos);

            //添加物料清单信息
            //**********此部分重构

            ArrayList<TemplateMaterialVo> material = insertVopro.getMaterial();
            ArrayList<com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo> insertProMaterialVos = new ArrayList<>();
            for(TemplateMaterialVo item:material){

                insertProMaterialVos.add(new com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo(uuid,String.valueOf(item.getMaterial_id()),item.getCount(),String.valueOf(item.getCompany_id())));
            }
            mapper.addProMaterialLists(insertProMaterialVos);
            return "添加成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:添加产品详细信息失败！");
            return "添加失败";
        }
    }

    @Override
    public String add3(InsertVo insertVo) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String status = "正常";
            String operator_id = insertVo.getOperator_id();
            String uuid = UUID.randomUUID().toString().replace("-","");
            //添加产品信息
            InsertProductVo product = insertVo.getProduct();
//            if (productMapper.checkDuplicate(product.getName(),product.getBrand(),product.getStyle(),product.getColor())!=0){
//                return "添加失败";
//            }
            product.setProduct_id(uuid);
            product.setCreated_time(timestamp);
            product.setOperator_id(operator_id);
            product.setStatus("正常");
            mapper.addProduct(product);
            //添加工艺路线概述信息
            InsertProcessVo process = insertVo.getProcess();
            InsertRoutingVo insertRoutingVo = new InsertRoutingVo(process.getComments(),operator_id);
            insertRoutingVo.setRouting_id(uuid);
            insertRoutingVo.setCreated_time(timestamp);
            insertRoutingVo.setStatus(status);
            //设置公司id
            insertRoutingVo.setCompany_id(product.getCompany_id());
            mapper.addRouting(insertRoutingVo);
            //添加工艺路线详细信息
            ArrayList<InsertRoutingProcedureVo> data = process.getData();
            ArrayList<com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo> insertRoutingProcedureVos = new ArrayList<>();
            int order = 1;
            for(InsertRoutingProcedureVo item:data){
                String procedure_id = nameIDMapper.getProcedureIDByName(item.getContent());
                insertRoutingProcedureVos.add(new com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo(uuid,procedure_id,order++,product.getCompany_id()));
            }
            mapper.addRoutingInfos(insertRoutingProcedureVos);

            //添加物料清单信息
            //**********   修改属性 去掉color

            ArrayList<InsertProMaterialVo> material = insertVo.getMaterial();
            ArrayList<com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo> insertProMaterialVos = new ArrayList<>();
            for(InsertProMaterialVo item:material){

                String size=item.getSize().replace(",","\",\"");
                 size=size.replace(":","\":\"");

                String material_id = nameIDMapper.getMaterialIDByNameSize(item.getName(),size);
                insertProMaterialVos.add(new com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo(uuid,material_id,item.getCount(),product.getCompany_id()));
            }
            mapper.addProMaterialLists(insertProMaterialVos);
            return "添加成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:添加产品详细信息失败！");
            return "添加失败";
        }
    }


    @Override
    public QueryVo getInfosByID(String product_id) {
        try {
            QueryProductVo product = productMapper.getProductByID(product_id);
            HashMap<String,Object> process = new HashMap<>();
            QueryRoutingVo queryRoutingVo = routingMapper.getRoutingByID(product_id);
            process.put("comments",queryRoutingVo.getComments());
            process.put("status",queryRoutingVo.getStatus());
            process.put("cost",routingMapper.getCostByID(product_id));
            ArrayList<QueryRoutingProcedureVo> data = routingMapper.getRoutingInfosByID(product_id);
            process.put("data",data);
            ArrayList<QueryProMaterialVo> material = materialMapper.getProMaterialListsByProID(product_id);
            QueryVo queryVo = new QueryVo(product,process,material);
            return queryVo;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:获取产品具体信息失败！");
            return null;
        }
    }


    @Override
    public String update(UpdateVo updateVo) {
        try {
            UpdateProductVo product = updateVo.getProduct();
            UpdateProcessVo process = updateVo.getProcess();
            String product_id = product.getProduct_id();
            String operator_id = updateVo.getOperator_id();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //修改产品信息
            com.example.mes.process.Vo.ProductVo.UpdateProductVo updateProductVo = new com.example.mes.process.Vo.ProductVo.UpdateProductVo(product_id,operator_id,product.getStatus(),product.getComments());
            updateProductVo.setModified_time(timestamp);
            mapper.updateProductByID(updateProductVo);
            //修改工艺路线信息
            UpdateRoutingVo updateRoutingVo = new UpdateRoutingVo(product_id,process.getStatus(),process.getComments(),operator_id);
            updateRoutingVo.setModified_time(timestamp);
            mapper.updateRoutingByID(updateRoutingVo);
            //修改工艺路线详细信息
            ArrayList<com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo> insertRoutingProcedureVos = new ArrayList<>();
            ArrayList<UpdateRoutingProcedureVo> data = process.getData();
            int order = 1;
            for(UpdateRoutingProcedureVo item:data){
                String procedure_id = nameIDMapper.getProcedureIDByName(item.getName());
                insertRoutingProcedureVos.add(new com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo(product_id,procedure_id,order++,product.getCompany_id()));
            }
            mapper.deleteRoutingProcedureByID(product_id);
            mapper.addRoutingInfos(insertRoutingProcedureVos);
            //修改物料清单信息
            ArrayList<InsertProMaterialVo> material = updateVo.getMaterial();
            ArrayList<com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo> insertProMaterialVos = new ArrayList<>();
            for(InsertProMaterialVo item:material){
                String material_id = nameIDMapper.getMaterialIDByNameSizeColor(item.getName(),item.getSize());
                insertProMaterialVos.add(new com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo(product_id,material_id,item.getCount()));
            }
            mapper.deleteProMaterialLists(product_id);
            mapper.addProMaterialLists(insertProMaterialVos);
            return "更新成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:更新产品具体信息失败！");
            return "更新失败";
        }
    }

    @Override
    public String update2(UpdateVopro updateVopro) {
        try {
            UpdateProductVo product = updateVopro.getProduct();
            UpdateProcessVo process = updateVopro.getProcess();
            String product_id = product.getProduct_id();
            String operator_id = updateVopro.getOperator_id();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //修改产品信息
            com.example.mes.process.Vo.ProductVo.UpdateProductVo updateProductVo = new com.example.mes.process.Vo.ProductVo.UpdateProductVo(product_id,operator_id,product.getStatus(),product.getComments());
            updateProductVo.setModified_time(timestamp);
            mapper.updateProductByID(updateProductVo);
            //修改工艺路线信息
            UpdateRoutingVo updateRoutingVo = new UpdateRoutingVo(product_id,process.getStatus(),process.getComments(),operator_id);
            updateRoutingVo.setModified_time(timestamp);
            mapper.updateRoutingByID(updateRoutingVo);
            //修改工艺路线详细信息
            ArrayList<com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo> insertRoutingProcedureVos = new ArrayList<>();
            ArrayList<UpdateRoutingProcedureVo> data = process.getData();
            int order = 1;
            for(UpdateRoutingProcedureVo item:data){
                String procedure_id = nameIDMapper.getProcedureIDByName(item.getName());
                insertRoutingProcedureVos.add(new com.example.mes.process.Vo.RoutingVo.InsertRoutingProcedureVo(product_id,procedure_id,order++,product.getCompany_id()));
            }
            mapper.deleteRoutingProcedureByID(product_id);
            mapper.addRoutingInfos(insertRoutingProcedureVos);
            //修改物料清单信息
            ArrayList<TemplateMaterialVo> material = updateVopro.getMaterial();
            ArrayList<com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo> insertProMaterialVos = new ArrayList<>();
            for(TemplateMaterialVo item:material){

                insertProMaterialVos.add(new com.example.mes.process.Vo.MaterialVo.InsertProMaterialVo(product_id,String.valueOf(item.getMaterial_id()),item.getCount(),String.valueOf(item.getCompany_id())));
            }
            mapper.deleteProMaterialLists(product_id);
            mapper.addProMaterialLists(insertProMaterialVos);
            return "更新成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("service:更新产品具体信息失败！");
            return "更新失败";
        }
    }

}
