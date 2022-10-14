package com.example.mes.template.entity;

import java.io.Serializable;

public class EquipmentTemplate implements Serializable {
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

    public int getEquipment_id() {
        return id;
    }

    public void setEquipment_id(int equipment_id) {
        this.id = equipment_id;
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

    public int getEquipmentCode() {
        return  id;
    }

    @Override
    public String toString() {
        return "EquipmentTemplate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                ", company_id=" + company_id +
                '}';
    }
}
