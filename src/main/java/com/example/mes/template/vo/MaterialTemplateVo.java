package com.example.mes.template.vo;

import java.util.ArrayList;

//对应前端返回的一个定义好的模板
public class MaterialTemplateVo {
    int id;

    String name;

    ArrayList<String> attribute;

    int company_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type = "material";

    public MaterialTemplateVo(int id, String name, ArrayList<String> attribute, int company_id) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        this.company_id = company_id;
    }

    public MaterialTemplateVo() {

    }

    @Override
    public String toString() {
        return "MaterialTemplateVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attribute=" + attribute +
                ", company_id=" + company_id +
                ", type=" + type +
                '}';
    }

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
}
