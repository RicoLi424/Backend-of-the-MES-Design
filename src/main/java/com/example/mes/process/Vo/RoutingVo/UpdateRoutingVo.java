package com.example.mes.process.Vo.RoutingVo;

import java.sql.Timestamp;

public class UpdateRoutingVo {

    //工艺路线id
    String routing_id;
    //工艺路线状态
    String status;
    //工艺路线描述
    String comments;
    //修改人
    String operator_id;
    //修改时间，set赋值
    Timestamp modified_time;

    public UpdateRoutingVo() {
    }

    public UpdateRoutingVo(String routing_id, String status, String comments, String operator_id) {
        this.routing_id = routing_id;
        this.status = status;
        this.comments = comments;
        this.operator_id = operator_id;
    }

    public String getRouting_id() {
        return routing_id;
    }

    public void setRouting_id(String routing_id) {
        this.routing_id = routing_id;
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
        return "UpdateRoutingVo{" +
                "routing_id='" + routing_id + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }
}
