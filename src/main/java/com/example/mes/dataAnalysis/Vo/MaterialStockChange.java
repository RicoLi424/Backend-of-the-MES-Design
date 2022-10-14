package com.example.mes.dataAnalysis.Vo;

public class MaterialStockChange {

    String material_id;
    String date;
    int stock;

    public MaterialStockChange() {
    }

    public MaterialStockChange(String date, int stock) {
        this.date = date;
        this.stock = stock;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MaterialStockChange{" +
                "material_id='" + material_id + '\'' +
                ", date='" + date + '\'' +
                ", stock=" + stock +
                '}';
    }
}
