package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@ApiModel(value="edu.sdu.mes.plan.entity.MaterialApplication",
description = "物料申请单")
public class MaterialApplication extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6130481473375988739L;
	
	@ApiModelProperty("单号")
	private String no = "";
	
	@ApiModelProperty("预期数量")
	private Integer expectedQuantity;
	@ApiModelProperty("已出库数量")
	private Integer exportedQuantity;
	@ApiModelProperty("出库完成时间")
	private Timestamp exportFinishTime;
	
	@ApiModelProperty("生产过程单")
	private Plan plan;
	@ApiModelProperty("物料类型")
	private String materialId;	//unknown class
	
	public MaterialApplication() {
		super();
	}

	public MaterialApplication(String id, String status, String createdBy, Integer expectedQuantity,
			Plan process, String material) {
		super(id, status, createdBy);
		this.expectedQuantity = expectedQuantity;
		this.plan = process;
		this.materialId = material;
	}

	public MaterialApplication(String id, String status, String isDeleted, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy, String no, Integer expectedQuantity, Integer exportedQuantity,
			Timestamp exportFinishTime, Plan process, String material) {
		super(id, status, isDeleted, createdTime, createdBy, modifiedTime, modifiedBy);
		this.no = no;
		this.expectedQuantity = expectedQuantity;
		this.exportedQuantity = exportedQuantity;
		this.exportFinishTime = exportFinishTime;
		this.plan = process;
		this.materialId = material;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getExpectedQuantity() {
		return expectedQuantity;
	}

	public void setExpectedQuantity(Integer expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}

	public Integer getExportedQuantity() {
		return exportedQuantity;
	}

	public void setExportedQuantity(Integer exportedQuantity) {
		this.exportedQuantity = exportedQuantity;
	}

	public Timestamp getExportFinishTime() {
		return exportFinishTime;
	}

	public void setExportFinishTime(Timestamp exportFinishTime) {
		this.exportFinishTime = exportFinishTime;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String material) {
		this.materialId = material;
	}

	@Override
	public String toString() {
		return "MaterialApplication [no=" + no + ", expectedQuantity=" + expectedQuantity + ", exportedQuantity="
				+ exportedQuantity + ", exportFinishTime=" + exportFinishTime + ", process=" + plan + ", material="
				+ materialId + ", getId()=" + getId() + ", getStatus()=" + getStatus() + ", getIsDeleted()="
				+ getDeleted() + ", getCreatedTime()=" + getCreatedTime() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getModifiedTime()=" + getModifiedTime() + ", getModifiedBy()=" + getModifiedBy() + "]";
	}
	
}
