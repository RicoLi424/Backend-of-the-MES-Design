package com.example.mes.quality.bean.Vo;


public class QualityListVo {

    private String filter_workshopID;
    private String filter_lineID;
    private String filter_status;
    private Integer pageSize;
    private Integer pageNum;
    private String sort;
    private String sortMethod;
    private Integer company_id;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getFilter_workshopID() {
        return filter_workshopID;
    }

    public void setFilter_workshopID(String filter_workshopID) {
        this.filter_workshopID = filter_workshopID;
    }

    public String getFilter_lineID() {
        return filter_lineID;
    }

    public void setFilter_lineID(String filter_lineID) {
        this.filter_lineID = filter_lineID;
    }

    public String getFilter_status() {
        return filter_status;
    }

    public void setFilter_status(String filter_status) {
        this.filter_status = filter_status;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
}
