package com.example.mes.process.Vo.RoutingVo;

public class QueryRoutingProcedureVo {

    //id
    String procedure_id;
    //工序名称
    String name;
    //工序描述
    String comments;
    //工序顺序

    public QueryRoutingProcedureVo() {
    }

    public QueryRoutingProcedureVo(String procedure_id, String name, String comments) {
        this.procedure_id = procedure_id;
        this.name = name;
        this.comments = comments;
    }

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "QueryRoutingProcedureVo{" +
                "procedure_id='" + procedure_id + '\'' +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
