package com.example.mes.template.entity;

import java.io.Serializable;

//数据库实体，关系表中一条记录
public class MaterialTemplate implements Serializable {
    int id;
    String name;
    String attribute;
    int company_id;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getMaterial_id() {
        return id;
    }

    public void setMaterial_id(int material_id) {
        this.id = material_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }



    public int getMaterialCode() {
        return  id;
    }


}
