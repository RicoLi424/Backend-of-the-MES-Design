package com.example.mes.WorkshopStorage.vo;

import java.sql.Timestamp;
import java.util.List;

public class StorageVo {
    private String uuid;
    private String id;
    private String status;
    private String is_deleted;
    private Timestamp created_time;
    private String created_by;
    private Timestamp modified_time;
    private String modified_by;
    private int shelf_Num;
    private List<ShelfVo> Shelfs;
    private String company_id;
    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public List<ShelfVo> getShelfs() {
        return Shelfs;
    }

    public void setShelfs(List<ShelfVo> shelfs) {
        Shelfs = shelfs;
    }

    public int getShelf_Num() {
        return shelf_Num;
    }

    public void setShelf_Num(int shelf_Num) {
        this.shelf_Num = shelf_Num;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }
}
