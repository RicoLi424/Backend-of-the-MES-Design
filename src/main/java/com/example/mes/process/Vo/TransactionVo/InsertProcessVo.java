package com.example.mes.process.Vo.TransactionVo;

import java.util.ArrayList;

public class InsertProcessVo {

    String comments;
    ArrayList<InsertRoutingProcedureVo> data;

    public InsertProcessVo() {
    }

    public InsertProcessVo(String comments, ArrayList<InsertRoutingProcedureVo> data) {
        this.comments = comments;
        this.data = data;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ArrayList<InsertRoutingProcedureVo> getData() {
        return data;
    }

    public void setData(ArrayList<InsertRoutingProcedureVo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InsertProcessVo{" +
                "comments='" + comments + '\'' +
                ", data=" + data +
                '}';
    }
}
