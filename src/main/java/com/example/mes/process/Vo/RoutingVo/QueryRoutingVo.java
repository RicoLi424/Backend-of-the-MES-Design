package com.example.mes.process.Vo.RoutingVo;

public class QueryRoutingVo {

    //工艺路线id
    String routing_id;
    //工艺路线状态
    String status;
    //工艺路线描述
    String comments;
    //耗费
    double cost;

    public QueryRoutingVo() {
    }

    public QueryRoutingVo(String routing_id, String status, String comments, double cost) {
        this.routing_id = routing_id;
        this.status = status;
        this.comments = comments;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "QueryRoutingVo{" +
                "routing_id='" + routing_id + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                '}';
    }
}
