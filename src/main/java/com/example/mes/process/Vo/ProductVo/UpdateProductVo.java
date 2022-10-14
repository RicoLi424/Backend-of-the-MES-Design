package com.example.mes.process.Vo.ProductVo;

import java.sql.Timestamp;

public class UpdateProductVo {

    //产品id
    String product_id;
    //修改人
    String operator_id;
    //产品状态
    String status;
    //产品描述
    String comments;
    //修改时间，使用set赋值
    Timestamp modified_time;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;

    public UpdateProductVo() {
    }

    public UpdateProductVo(String product_id, String operator_id, String status, String comments) {
        this.product_id = product_id;
        this.operator_id = operator_id;
        this.status = status;
        this.comments = comments;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
        return "UpdateProductVo{" +
                "product_id='" + product_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", modified_time=" + modified_time +
                ", company_id='" + company_id + '\'' +
                '}';
    }
}
