package com.example.mes.process.Vo.RoutingVo;

import java.sql.Timestamp;

public class InsertRoutingVo {

    //uuid，使用set赋值
    String routing_id;
    //工艺路线描述
    String comments;
    //状态，使用set赋值
    String status;
    //创建人
    String operator_id;
    //创建时间，使用set赋值
    Timestamp created_time;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    String company_id;

    public InsertRoutingVo() {
    }

    public InsertRoutingVo(String comments, String operator_id) {
        this.comments = comments;
        this.operator_id = operator_id;
    }

    public String getRouting_id() {
        return routing_id;
    }

    public void setRouting_id(String routing_id) {
        this.routing_id = routing_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "InsertRoutingVo{" +
                "routing_id='" + routing_id + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", created_time=" + created_time +
                ", company_id='" + company_id + '\'' +
                '}';
    }
}
