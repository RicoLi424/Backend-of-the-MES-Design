package com.example.mes.process.Vo.TransactionVo;


import java.util.ArrayList;

public class UpdateVo {

    //添加的产品信息
    UpdateProductVo product;
    //工艺路线信息
    UpdateProcessVo process;
    //物料清单
    ArrayList<InsertProMaterialVo> material;
    //操作者
    String operator_id;


    public UpdateVo() {
    }

    public UpdateVo(UpdateProductVo product, UpdateProcessVo process, ArrayList<InsertProMaterialVo> material, String operator_id) {
        this.product = product;
        this.process = process;
        this.material = material;
        this.operator_id = operator_id;
    }

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
        return "UpdateVo{" +
                "product=" + product +
                ", process=" + process +
                ", material=" + material +
                ", operator_id='" + operator_id + '\'' +
                '}';
    }
}
