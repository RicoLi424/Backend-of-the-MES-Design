package com.example.mes.process.Vo.RoutingVo;

import java.sql.Timestamp;

public class DeleteRoutingVo {

    //要删除的工艺路线的id
    String routing_id;
    //删除人id
    String operator_id;
    //删除时间，使用set赋值
    Timestamp modified_time;

    String company_id;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public DeleteRoutingVo() {
    }

    public DeleteRoutingVo(String routing_id, String operator_id) {
        this.routing_id = routing_id;
        this.operator_id = operator_id;
    }

    public String getRouting_id() {
        return routing_id;
    }

    public void setRouting_id(String routing_id) {
        this.routing_id = routing_id;
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

    @Override
    public String toString() {
        return "DeleteRoutingVo{" +
                "routing_id='" + routing_id + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }
}
