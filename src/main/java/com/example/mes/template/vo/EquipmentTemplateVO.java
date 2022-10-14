package com.example.mes.template.vo;

import java.util.ArrayList;

public class EquipmentTemplateVO {
    int id;

    String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type = "equipment";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAttribute() {
        return attribute;
    }

    public void setAttribute(ArrayList<String> attribute) {
        this.attribute = attribute;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    ArrayList<String> attribute;

    int company_id;



    @Override
    public String toString() {
        return "EquipmentTemplateVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attribute=" + attribute +
                ", company_id=" + company_id +
                ", type=" + type +
                '}';
    }
}
