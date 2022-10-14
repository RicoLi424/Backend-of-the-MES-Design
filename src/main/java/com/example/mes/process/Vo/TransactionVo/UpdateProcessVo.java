package com.example.mes.process.Vo.TransactionVo;

import java.util.ArrayList;

public class UpdateProcessVo {

    String comments;
    double cost;
    String status;
    ArrayList<UpdateRoutingProcedureVo> data;

    public UpdateProcessVo() {
    }

    public UpdateProcessVo(String comments, double cost, String status, ArrayList<UpdateRoutingProcedureVo> data) {
        this.comments = comments;
        this.cost = cost;
        this.status = status;
        this.data = data;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<UpdateRoutingProcedureVo> getData() {
        return data;
    }

    public void setData(ArrayList<UpdateRoutingProcedureVo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UpdateProcessVo{" +
                "comments='" + comments + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
