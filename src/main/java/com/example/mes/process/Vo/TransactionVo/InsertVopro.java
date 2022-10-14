package com.example.mes.process.Vo.TransactionVo;



import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;
import com.example.mes.process.Vo.ProductVo.InsertProductVo;

import java.util.ArrayList;


public class InsertVopro {

    //添加的产品信息
    InsertProductVo product;
    //工艺路线信息
    InsertProcessVo process;

    public ArrayList<TemplateMaterialVo> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<TemplateMaterialVo> material) {
        this.material = material;
    }

    //物料清单
    ArrayList<TemplateMaterialVo> material;
    //操作者
    String operator_id;



    public InsertProductVo getProduct() {
        return product;
    }

    public void setProduct(InsertProductVo product) {
        this.product = product;
    }

    public InsertProcessVo getProcess() {
        return process;
    }

    public void setProcess(InsertProcessVo process) {
        this.process = process;
    }



    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    @Override
    public String toString() {
        return "InsertVo{" +
                "product=" + product +
                ", process=" + process +
                ", material=" + material +
                ", operator_id='" + operator_id + '\'' +
                '}';
    }
}
