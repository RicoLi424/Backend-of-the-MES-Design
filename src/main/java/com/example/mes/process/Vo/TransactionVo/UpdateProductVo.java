package com.example.mes.process.Vo.TransactionVo;

public class UpdateProductVo {


    String product_id;
    String brand;
    String name;
    String style;
    String color;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String status;
    String comments;
    String company_id;

    public UpdateProductVo() {
    }

    public UpdateProductVo(String product_id, String brand, String name, String style, String color, String status, String comments) {
        this.product_id = product_id;
        this.brand = brand;
        this.name = name;
        this.style = style;
        this.color = color;
        this.status = status;
        this.comments = comments;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    @Override
    public String toString() {
        return "UpdateProductVo{" +
                "product_id='" + product_id + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }


}


