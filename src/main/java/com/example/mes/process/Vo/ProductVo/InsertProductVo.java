package com.example.mes.process.Vo.ProductVo;

import java.sql.Timestamp;

public class InsertProductVo {

    //uuid，使用set赋值
    String product_id;
    //创建人
    String operator_id;
    //品牌
    String brand;
    //季节
    String season;
    //产品类型
    String type;
    //颜色
    String color;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    //客户款号
    String customer_id;
    //公司款号
    String company;
    //描述
    String comments;
    //产品状态，使用set赋值
    String status;
    //创建时间，使用set赋值
    Timestamp created_time;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;

    public InsertProductVo() {
    }

    public InsertProductVo(String operator_id, String brand, String season, String type, String color, String customer_id, String company, String comments) {
        this.operator_id = operator_id;
        this.brand = brand;
        this.season = season;
        this.type = type;
        this.color = color;
        this.customer_id = customer_id;
        this.company = company;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }



    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "InsertProductVo{" +
                "product_id='" + product_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", brand='" + brand + '\'' +
                ", season='" + season + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", company='" + company + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", created_time=" + created_time +
                ", company_id='" + company_id + '\'' +
                '}';
    }
}
