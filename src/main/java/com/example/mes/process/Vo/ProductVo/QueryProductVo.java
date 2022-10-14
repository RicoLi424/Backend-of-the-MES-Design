package com.example.mes.process.Vo.ProductVo;

public class QueryProductVo {

    //产品id
    String product_id;
    //产品类别
    String type;
    //产品品牌
    String brand;
    //产品款式
    String season;
    //产品颜色
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
    //产品描述
    String comments;
    //产品状态
    String status;

    public QueryProductVo() {
    }

    public QueryProductVo(String product_id, String type, String brand, String season, String color, String customer_id, String company, String comments, String status) {
        this.product_id = product_id;
        this.type = type;
        this.brand = brand;
        this.season = season;
        this.color = color;
        this.customer_id = customer_id;
        this.company = company;
        this.comments = comments;
        this.status = status;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "QueryProductVo{" +
                "product_id='" + product_id + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", season='" + season + '\'' +
                ", color='" + color + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", company='" + company + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

