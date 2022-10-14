package com.example.mes.process.Vo.RoutingVo;

public class InsertRoutingProcedureVo {

    //工艺路线id
    String routing_id;
    //工序id
    String procedure_id;
    //顺序
    int order;

    public InsertRoutingProcedureVo(String routing_id, String procedure_id, int order, String company_id) {
        this.routing_id = routing_id;
        this.procedure_id = procedure_id;
        this.order = order;
        this.company_id = company_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;

    public InsertRoutingProcedureVo() {
    }

    public InsertRoutingProcedureVo(String routing_id, String procedure_id, int order) {
        this.routing_id = routing_id;
        this.procedure_id = procedure_id;
        this.order = order;
    }

    public String getRouting_id() {
        return routing_id;
    }

    public void setRouting_id(String routing_id) {
        this.routing_id = routing_id;
    }

    public String getProcedure_id() {
        return procedure_id;
    }

    public void setProcedure_id(String procedure_id) {
        this.procedure_id = procedure_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "InsertRoutingProcedureVo{" +
                "routing_id='" + routing_id + '\'' +
                ", procedure_id='" + procedure_id + '\'' +
                ", order=" + order +
                '}';
    }
}
