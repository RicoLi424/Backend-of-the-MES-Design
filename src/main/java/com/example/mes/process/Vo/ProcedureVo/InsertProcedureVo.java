package com.example.mes.process.Vo.ProcedureVo;

import java.sql.Timestamp;

public class InsertProcedureVo {

    //uuid，使用set赋值
    String procedure_id;
    //工序名称
    String name;
    //耗费
    double cost;
    //描述
    String comments;
    //创建人
    String operator_id;
    //状态，使用set赋值
    String status;
    //创建时间，使用set赋值
    Timestamp created_time;

    int company_id;

    public String getProcedure_id() {
        return procedure_id;
    }

    public void setProcedure_id(String procedure_id) {
        this.procedure_id = procedure_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "InsertProcedureVo{" +
                "procedure_id='" + procedure_id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", comments='" + comments + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", status='" + status + '\'' +
                ", created_time=" + created_time +
                ", company_id=" + company_id +
                '}';
    }
}
