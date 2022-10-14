package com.example.mes.process.Vo.EquipmentVo;

public class QueryEquipmentVo {

    String equipment_id;
    String name;
    String purpose;
    String status;
    String comments;
    int company_id;

    @Override
    public String toString() {
        return "QueryEquipmentVo{" +
                "equipment_id='" + equipment_id + '\'' +
                ", name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", company_id=" + company_id +
                '}';
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

}
