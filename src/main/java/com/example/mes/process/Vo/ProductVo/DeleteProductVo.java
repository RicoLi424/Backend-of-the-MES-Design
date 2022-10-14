package com.example.mes.process.Vo.ProductVo;

import java.sql.Timestamp;

public class DeleteProductVo {

    //要删除的产品的id
    String product_id;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;
    //删除人id
    String operator_id;
    //删除时间，使用set赋值
    Timestamp modified_time;

    public DeleteProductVo() {
    }

    public DeleteProductVo(String product_id, String operator_id) {
        this.product_id = product_id;
        this.operator_id = operator_id;
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

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    @Override
    public String toString() {
        return "DeleteProductVo{" +
                "product_id='" + product_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }

}
