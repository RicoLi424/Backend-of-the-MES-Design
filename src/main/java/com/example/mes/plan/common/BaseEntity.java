package com.example.mes.plan.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;

@ApiModel(value="edu.sdu.mes.entity.BaseEntity",
	description = "统一继承实体基类，里面包含每个实体类公共的字段")
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -223864587820855375L;

	private String id;
	
	@ApiModelProperty("状态")
	private String status;
	
	@ApiModelProperty("已被删除")
	private String deleted;
	
	@ApiModelProperty("创建时间")
	private Timestamp createdTime;
	
	@ApiModelProperty("创建者")
	private String createdBy;
	
	@ApiModelProperty("修改时间")
	private Timestamp modifiedTime;
	
	@ApiModelProperty("修改者")
	private String modifiedBy;

	public BaseEntity() {
		super();
	}

	public BaseEntity(String id, String status, String createdBy) {
		super();
		this.id = id;
		this.status = status;
		this.createdBy = createdBy;
		
	}

	
	
	public BaseEntity(String id, String status, String isDeleted, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy) {
		super();
		this.id = id;
		this.status = status;
		this.deleted = isDeleted;
		this.createdTime = createdTime;
		this.createdBy = createdBy;
		this.modifiedTime = modifiedTime;
		this.modifiedBy = modifiedBy;
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return String.format(
				"BaseEntity [id=%s, status=%s, isDeleted=%s, createdTime=%s, createdBy=%s, modifiedTime=%s, modifiedBy=%s]",
				id, status, deleted, createdTime, createdBy, modifiedTime, modifiedBy);
	}
	
	
}
