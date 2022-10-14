package com.example.mes.process.Vo.ProcedureVo;

public class QueryProcedureVo {

    //工序id
    int procedure_id;
    //工序名称
    String name;
    //工序状态
    String status;
    //工序描述
    String comments;
    //耗费
    double cost;

    int company_id;

    @Override
    public String toString() {
        return "QueryProcedureVo{" +
                "procedure_id=" + procedure_id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                ", company_id=" + company_id +
                '}';
    }

    public int getProcedure_id() {
        return procedure_id;
    }

    public void setProcedure_id(int procedure_id) {
        this.procedure_id = procedure_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
