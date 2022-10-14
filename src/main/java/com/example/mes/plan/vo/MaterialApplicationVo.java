package com.example.mes.plan.vo;

import com.example.mes.plan.entity.MaterialApplication;
import com.example.mes.plan.entity.Plan;

import java.sql.Timestamp;

public class MaterialApplicationVo  {
	private MaterialApplication ma = new MaterialApplication();

	public MaterialApplicationVo() {
		super();
	}

	public MaterialApplicationVo(MaterialApplication ma) {
		super();
		this.ma = ma;
	}

	public MaterialApplication getMa() {
		return ma;
	}

	public void setMa(MaterialApplication ma) {
		this.ma = ma;
	}
	
	public String getNo() {
		return ma.getNo();
	}

	public void setNo(String no) {
		this.ma.setNo(no);
	}

	public Integer getExpectedQuantity() {
		return ma.getExpectedQuantity();
	}

	public void setExpectedQuantity(Integer expectedQuantity) {
		this.ma.setExpectedQuantity(expectedQuantity);
	}

	public Integer getExportedQuantity() {
		return ma.getExportedQuantity();
	}

	public void setExportedQuantity(Integer exportedQuantity) {
		this.ma.setExportedQuantity(exportedQuantity);
	}

	public Timestamp getExportFinishTime() {
		return ma.getExportFinishTime();
	}

	public void setExportFinishTime(Timestamp exportFinishTime) {
		this.ma.setExportFinishTime(exportFinishTime);
	}

	public Plan getPlan() {
		return ma.getPlan();
	}

	public void setPlan(Plan process) {
		this.ma.setPlan(process);
	}

	public String getMaterialId() {
		return ma.getMaterialId();
	}

	public void setMaterialId(String material) {
		this.ma.setMaterialId(material);
	}
	
	public String getId() {
		return ma.getId();
	}

	public void setId(String id) {
		this.ma.setId(id);
	}

	public String getStatus() {
		return ma.getStatus();
	}

	public void setStatus(String status) {
		this.ma.setStatus(status);
	}

	public String getDeleted() {
		return ma.getDeleted();
	}

	public void setDeleted(String deleted) {
		this.ma.setDeleted(deleted);
	}

	public Timestamp getCreatedTime() {
		return ma.getCreatedTime();
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.ma.setCreatedTime(createdTime);
	}

	public String getCreatedBy() {
		return ma.getCreatedBy();
	}

	public void setCreatedBy(String createdBy) {
		this.ma.setCreatedBy(createdBy);
	}

	public Timestamp getModifiedTime() {
		return ma.getModifiedTime();
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.ma.setModifiedTime(modifiedTime);
	}

	public String getModifiedBy() {
		return ma.getModifiedBy();
	}

	public void setModifiedBy(String modifiedBy) {
		this.ma.setModifiedBy(modifiedBy);
	}
	
}
