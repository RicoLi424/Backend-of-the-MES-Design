package com.example.mes.process.Vo.MaterialVo;

import java.sql.Timestamp;

public class UpdateMaterialVo {

    //要修改的物料的id
    String material_id;
    //修改的人的id
    String operator_id;
    //修改后的status
    String status;
    //修改后的comments
    String comments;
    //修改时间，需要使用set赋值
    Timestamp modified_time;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    int company_id;

    public UpdateMaterialVo() {
    }

    public UpdateMaterialVo(String material_id, String operator_id, String status, String comments) {
        this.material_id = material_id;
        this.operator_id = operator_id;
        this.status = status;
        this.comments = comments;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    @Override
    public String toString() {
        return "UpdateMaterialVo{" +
                "material_id='" + material_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", modified_time=" + modified_time +
                ", company_id=" + company_id +
                '}';
    }
}
