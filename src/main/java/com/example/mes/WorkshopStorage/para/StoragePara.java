package com.example.mes.WorkshopStorage.para;

import java.util.List;

public class StoragePara {
    private String Storage_id;
    private List<Shelfpara> Shelfs;
    private String user;
    private String company_id;
    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStorage_id() {
        return Storage_id;
    }

    public void setStorage_id(String storage_id) {
        Storage_id = storage_id;
    }

    public List<Shelfpara> getShelfs() {
        return Shelfs;
    }

    public void setShelfs(List<Shelfpara> shelfs) {
        Shelfs = shelfs;
    }
}
