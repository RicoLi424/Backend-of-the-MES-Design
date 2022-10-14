package com.example.mes.process.Vo.MaterialVo;

import java.sql.Timestamp;

public class InsertMaterialVo {

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    //uuid，使用set赋值
    String material_id;
    //物料名称
    String name;
    //物料规格
    String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color;

    //物料描述
    String comments;
    //创建人的id
    String operator_id;
    //物料状态，需要使用set赋值
    String status;
    //创建时间，需要使用set赋值
    Timestamp created_time;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;

    public InsertMaterialVo() {
    }

    public InsertMaterialVo(String name, String size,  String comments, String operator_id) {
        this.name = name;
        this.size = size;

        this.comments = comments;
        this.operator_id = operator_id;
        //this.company_id = company_id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "InsertMaterialVo{" +
                "material_id='" + material_id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", comments='" + comments + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", status='" + status + '\'' +
                ", created_time=" + created_time +
                ", company_id=" + company_id +
                '}';
    }

}
