package com.example.mes.process.Vo.MaterialVo;

public class QueryProMaterialVo {

    //  TODO:修改物料的属性显示，size预计为json格式属性集合

    //物料id
    String material_id;
    //名称
    String name;

    //规格    //属性集合
    String size;
    //描述
    String comments;
    //数量
    int count;

    public QueryProMaterialVo() {
    }

    public QueryProMaterialVo(String material_id, String name,  String size, String comments, int count) {
        this.material_id = material_id;
        this.name = name;

        this.size = size;
        this.comments = comments;
        this.count = count;
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
        size=size.replace("\"", "");
        size=size.replace("{", "");
        size=size.replace("}", "");
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

    public double getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        size=size.replace("\"", "");
        size=size.replace("{", "");
        size=size.replace("}", "");
        return "QueryProMaterialVo{" +
                "material_id='" + material_id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", comments='" + comments + '\'' +
                ", count=" + count +
                '}';
    }
}
