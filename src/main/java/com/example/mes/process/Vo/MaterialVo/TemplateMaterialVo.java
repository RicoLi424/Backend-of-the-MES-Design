package com.example.mes.process.Vo.MaterialVo;

import java.util.HashMap;

public class TemplateMaterialVo {
    int material_id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public HashMap<String, String> getAttribute() {
        return attribute;
    }

    public void setAttribute(HashMap<String, String> attribute) {
        this.attribute = attribute;
    }

    HashMap<String,String> attribute;

    int company_id;


    //用于产品添加物料
    int count;
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
