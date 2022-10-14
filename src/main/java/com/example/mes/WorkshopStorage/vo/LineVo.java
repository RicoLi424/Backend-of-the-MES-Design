package com.example.mes.WorkshopStorage.vo;

import java.sql.Timestamp;
import java.util.List;

public class LineVo {

    private String uuid;//uuid
    private String id;//id
    private String workshop_id;//车间id
    private String name;//产线名
    private List<StationVo> stations;//工位
    private int stationNum;//工位数量
    private int equipNum;//设备数量
    private String verify;
    private String pre_id;
    private Timestamp created_time;
    private Timestamp modified_time;
    private String created_by;
    private String modified_by;
    private String routing;
    private String company_id;



    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
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

    public String getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(String workshop_id) {
        this.workshop_id = workshop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StationVo> getStations() {
        return stations;
    }

    public void setStations(List<StationVo> stations) {
        this.stations = stations;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public int getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(int equipNum) {
        this.equipNum = equipNum;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }
}
