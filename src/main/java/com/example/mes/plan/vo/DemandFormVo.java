package com.example.mes.plan.vo;

import com.example.mes.plan.entity.DemandForm;
import com.example.mes.plan.entity.Product;

import java.sql.Date;
import java.sql.Timestamp;

public class DemandFormVo {
	private DemandForm df = new DemandForm();

	
	
	public DemandFormVo() {
		super();
	}

	public DemandFormVo(DemandForm df) {
		super();
		this.df = df;
	}

	public DemandForm getDf() {
		return df;
	}

	public void setDf(DemandForm df) {
		this.df = df;
	}
	
	public String getId() {
		return df.getId();
	}

	public void setId(String id) {
		this.df.setId(id);
	}
	
	public String getNo() {
		return df.getNo();
	}

	public void setNo(String no) {
		this.df.setNo(no);
	}

	public Integer getQuantity() {
		return df.getQuantity();
	}

	public void setQuantity(Integer quantity) {
		this.df.setQuantity(quantity);
	}

	public Date getExpectedDate() {
		return df.getExpectedDate();
	}

	public void setExpectedDate(Date expectedDate) {
		this.df.setExpectedDate(expectedDate);
	}

	public Timestamp getReadTime() {
		return df.getReadTime();
	}

	public void setReadTime(Timestamp readTime) {
		this.df.setReadTime(readTime);
	}

	public Boolean getWaiting() {
		return df.getWaiting();
	}

	public void setWaiting(Boolean waiting) {
		this.df.setWaiting(waiting);
	}

	public DemandForm getOriginalDemandForm() {
		return df.getOriginalDemandForm();
	}

	public void setOriginalDemandForm(DemandForm originalDemandForm) {
		this.df.setOriginalDemandForm(originalDemandForm);
	}

	public Object getProduct() {
		return df.getProduct();
	}

	public void setProduct(Product product) {
		this.df.setProduct(product);
	}
	
	public String getStatus() {
		return df.getStatus();
	}

	public void setStatus(String status) {
		this.df.setStatus(status);
	}

	public String getDeleted() {
		return df.getDeleted();
	}

	public void setDeleted(String deleted) {
		this.df.setDeleted(deleted);
	}

	public Timestamp getCreatedTime() {
		return df.getCreatedTime();
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.df.setCreatedTime(createdTime);
	}

	public String getCreatedBy() {
		return df.getCreatedBy();
	}

	public void setCreatedBy(String createdBy) {
		this.df.setCreatedBy(createdBy);
	}

	public Timestamp getModifiedTime() {
		return df.getModifiedTime();
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.df.setModifiedTime(modifiedTime);
	}

	public String getModifiedBy() {
		return df.getModifiedBy();
	}

	public void setModifiedBy(String modifiedBy) {
		this.df.setModifiedBy(modifiedBy);
	}

	public String getCompany_id() {
		return df.getCompany_id();
	}

	public void setCompany_id(String company_id) {
		this.df.setCompany_id(company_id);
	}
}
