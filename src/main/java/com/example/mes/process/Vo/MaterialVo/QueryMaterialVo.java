package com.example.mes.process.Vo.MaterialVo;

public class QueryMaterialVo {

    //物料的id
    String material_id;
    //名称
    String name;
    //规格
    String size;
    //颜色
    String color;
    //描述
    String comments;
    //状态
    String status;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    int company_id;

    public QueryMaterialVo() {
    }

    public QueryMaterialVo(String material_id, String name, String size, String color, String comments, String status) {
        this.material_id = material_id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.comments = comments;
        this.status = status;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "QueryMaterialVo{" +
                "material_id='" + material_id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", company_id=" + company_id +
                '}';
    }
}
