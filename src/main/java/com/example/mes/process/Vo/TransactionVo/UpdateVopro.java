package com.example.mes.process.Vo.TransactionVo;

import com.example.mes.process.Vo.MaterialVo.TemplateMaterialVo;

import java.util.ArrayList;

public class UpdateVopro {


    //添加的产品信息
    UpdateProductVo product;
    //工艺路线信息
    UpdateProcessVo process;
    //物料清单
    ArrayList<TemplateMaterialVo> material;

    public ArrayList<TemplateMaterialVo> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<TemplateMaterialVo> material) {
        this.material = material;
    }

    //操作者
    String operator_id;




    public UpdateProductVo getProduct() {
        return product;
    }

    public void setProduct(UpdateProductVo product) {
        this.product = product;
    }

    public UpdateProcessVo getProcess() {
        return process;
    }

    public void setProcess(UpdateProcessVo process) {
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
        return "UpdateVo{" +
                "product=" + product +
                ", process=" + process +
                ", material=" + material +
                ", operator_id='" + operator_id + '\'' +
                '}';
    }
}
