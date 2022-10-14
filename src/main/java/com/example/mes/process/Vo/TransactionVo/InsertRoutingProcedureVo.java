package com.example.mes.process.Vo.TransactionVo;

public class InsertRoutingProcedureVo {

    String id;
    String content;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public InsertRoutingProcedureVo(String id, String content, String company_id) {
        this.id = id;
        this.content = content;
        this.company_id = company_id;
    }

    String company_id;

    public InsertRoutingProcedureVo() {
    }

    public InsertRoutingProcedureVo(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InsertRoutingProcedureVo{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", company_id='" + company_id + '\'' +
                '}';
    }
}
