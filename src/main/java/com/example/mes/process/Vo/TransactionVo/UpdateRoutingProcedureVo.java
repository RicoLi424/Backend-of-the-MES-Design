package com.example.mes.process.Vo.TransactionVo;

public class UpdateRoutingProcedureVo {

    String id;
    String name;

    public UpdateRoutingProcedureVo() {
    }

    public UpdateRoutingProcedureVo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UpdateRoutingProcedureVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
