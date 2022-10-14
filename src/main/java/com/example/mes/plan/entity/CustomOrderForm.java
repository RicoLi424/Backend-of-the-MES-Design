package com.example.mes.plan.entity;


/**
 *
 *
 * 客户订单类
 * 与数据库的 plan_demand_form 表相对应
 *
 */
public class CustomOrderForm {

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getExpected_date() {
        return expected_date;
    }

    public void setExpected_date(String expected_date) {
        this.expected_date = expected_date;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /*public CustomOrderForm(String no, String product_id, String quantity, String created_time, String expected_date, String type, String brand, String company, String color) {
        this.no = no;
        this.product_id = product_id;
        this.quantity = quantity;
        this.created_time = created_time;
        this.expected_date = expected_date;
        this.type = type;
        this.brand = brand;
        this.company = company;
        this.color = color;
    }

    public CustomOrderForm(String no, String product_id, String quantity, String created_time, String expected_date, String type, String brand, String company, String color, String season) {
        this.no = no;
        this.product_id = product_id;
        this.quantity = quantity;
        this.created_time = created_time;
        this.expected_date = expected_date;
        this.type = type;
        this.brand = brand;
        this.company = company;
        this.color = color;
        this.season = season;
    }*/

    public CustomOrderForm(String no, String product_id, String quantity, String created_time, String expected_date, String type, String brand, String company, String color, String season, String id) {
        //给前端数据使用
        this.no = no;
        this.product_id = product_id;
        this.quantity = quantity;
        this.created_time = created_time;
        this.expected_date = expected_date;
        this.type = type;
        this.brand = brand;
        this.company = company;
        this.color = color;
        this.season = season;
        this.id = id;
    }

    public CustomOrderForm(String id, String expected_date, String quantity, String product_id) {
        //传输前端来的数据
        this.product_id = product_id;
        this.quantity = quantity;
        this.expected_date = expected_date;
        this.id = id;
    }
    private String no;
    private String product_id;
    private String quantity;
    private String created_time;
    private String expected_date;
    private String type;
    private String brand;
    private String company;
    private String color;
    private String season;
    private String id;


}
