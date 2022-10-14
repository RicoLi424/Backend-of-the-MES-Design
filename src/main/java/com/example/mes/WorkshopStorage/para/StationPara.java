package com.example.mes.WorkshopStorage.para;

public class StationPara {
    /**
     * uuid
     */
    private String uuid;
    /**
     *车间编号
     */
    private String workshopId;

    /**
     *产线编号
     */
    private String lineId;
    /**
     *工位编号
     */
    private String stationId;

    /**
     *工位位序
     */
    private String staOrd;
    /**
     *工位工人
     */
    private String user;

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

    public String getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(String workshopId) {
        this.workshopId = workshopId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStaOrd() {
        return staOrd;
    }

    public void setStaOrd(String staOrd) {
        this.staOrd = staOrd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStaEqu() {
        return staEqu;
    }

    public void setStaEqu(String staEqu) {
        this.staEqu = staEqu;
    }

    /**
     *设备编号
     */
    private String staEqu;

}