package com.example.mes.process.Vo.ProcedureVo;

import java.sql.Timestamp;

public class UpdateProcedureVo {

    //要修改的工序的id
    String procedure_id;
    //修改后的状态
    String status;
    //修改后的描述
    String comments;
    //修改后的耗费
    double cost;
    //修改人
    String operator_id;
    //修改时间，使用set赋值
    Timestamp modified_time;

    int company_id;

    public String getProcedure_id() {
        return procedure_id;
    }

    public void setProcedure_id(String procedure_id) {
        this.procedure_id = procedure_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "UpdateProcedureVo{" +
                "procedure_id='" + procedure_id + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                ", operator_id='" + operator_id + '\'' +
                ", modified_time=" + modified_time +
                ", company_id=" + company_id +
                '}';
    }
}
