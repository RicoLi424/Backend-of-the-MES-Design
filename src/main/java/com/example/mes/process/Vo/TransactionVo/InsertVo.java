package com.example.mes.process.Vo.TransactionVo;

import com.example.mes.process.Vo.ProductVo.InsertProductVo;

import java.util.ArrayList;


public class InsertVo {

    //添加的产品信息
    InsertProductVo product;
    //工艺路线信息
    InsertProcessVo process;
    //物料清单
    ArrayList<InsertProMaterialVo> material;
    //操作者
    String operator_id;

    public InsertVo() {
    }

    public InsertVo(InsertProductVo product, InsertProcessVo process, ArrayList<InsertProMaterialVo> material, String operator_id) {
        this.product = product;
        this.process = process;
        this.material = material;
        this.operator_id = operator_id;
    }

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

    public ArrayList<InsertProMaterialVo> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<InsertProMaterialVo> material) {
        this.material = material;
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
