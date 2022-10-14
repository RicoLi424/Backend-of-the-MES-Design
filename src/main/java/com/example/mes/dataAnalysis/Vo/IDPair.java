package com.example.mes.dataAnalysis.Vo;

public class IDPair {

    String product_id;
    String id;
    int is_waiting;

    public IDPair() {
    }

    public IDPair(String product_id, String id, int is_waiting) {
        this.product_id = product_id;
        this.id = id;
        this.is_waiting = is_waiting;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIs_waiting() {
        return is_waiting;
    }

    public void setIs_waiting(int is_waiting) {
        this.is_waiting = is_waiting;
    }

    @Override
    public String toString() {
        return "IDPair{" +
                "product_id='" + product_id + '\'' +
                ", id='" + id + '\'' +
                ", is_waiting=" + is_waiting +
                '}';
    }
}
