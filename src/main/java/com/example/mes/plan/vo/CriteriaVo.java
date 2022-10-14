package com.example.mes.plan.vo;

import java.sql.Timestamp;
import java.util.Date;

public class CriteriaVo<T> {
	
	private T entityVo;
	/**
     * 哪一页
     */

    private Integer pageNo = 1;

    /**
     * 每页条数
     */
    private Integer pageSize=2;
    
    //开始时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginTimestamp;
    
    //结束时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTimestamp;

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	private String company_id;

	public CriteriaVo(T entityVo, Integer pageNo, Integer pageSize, Date beginTimestamp, Date endTimestamp, String company_id) {
		this.entityVo = entityVo;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.beginTimestamp = beginTimestamp;
		this.endTimestamp = endTimestamp;
		this.company_id = company_id;
	}

	public CriteriaVo() {
		super();
	}

	public CriteriaVo(T entityVo, Integer pageNo, Integer pageSize, Date beginTimestamp, Date endTimestamp) {
		super();
		this.entityVo = entityVo;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.beginTimestamp = beginTimestamp;
		this.endTimestamp = endTimestamp;
	}
	
	public Integer getLimit() {
		return (this.pageNo-1)*this.pageSize;
	}

	

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Date getBeginTimestamp() {
		return beginTimestamp;
	}

	public void setBeginTimestamp(Timestamp beginTimestamp) {
		this.beginTimestamp = beginTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public T getEntityVo() {
		return entityVo;
	}

	public void setEntityVo(T entityVo) {
		this.entityVo = entityVo;
	}

	@Override
	public String toString() {
		return "CriteriaVo [entityVo=" + entityVo + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", beginTimestamp=" + beginTimestamp + ", endTimestamp=" + endTimestamp +", company_id=" + company_id + "]";
	}
}
