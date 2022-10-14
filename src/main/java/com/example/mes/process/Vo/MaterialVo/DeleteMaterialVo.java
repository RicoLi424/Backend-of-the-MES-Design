package com.example.mes.process.Vo.MaterialVo;

import java.sql.Timestamp;

public class DeleteMaterialVo {

    //要删除的物料的id
    String material_id;
    //删除人的id
    String operator_id;
    //删除的时间，需要使用set赋值
    Timestamp modified_time;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    int company_id;

    public DeleteMaterialVo() {
    }

    public DeleteMaterialVo(String material_id, String operator_id) {
        this.material_id = material_id;
        this.operator_id = operator_id;
    }

    @Override
    public String toString() {
        return "DeleteMaterialVo{" +
                "material_id='" + material_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", modified_time=" + modified_time +
                ", company_id=" + company_id +
                '}';
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }



}
