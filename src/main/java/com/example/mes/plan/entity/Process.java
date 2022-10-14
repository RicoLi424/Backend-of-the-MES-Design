package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@ApiModel(value="edu.sdu.mes.plan.entity.Process",
description = "生产过程单")
public class Process extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2445362112868893295L;

	@ApiModelProperty("单号")
	private String no = "";
	
	@ApiModelProperty("当前步骤")
	private Integer step;
	@ApiModelProperty("物料到达时间")
	private Timestamp materialArriveTime;
	@ApiModelProperty("所需数量")
	private Integer demandQuantity;
	@ApiModelProperty("已完成数量")
	private Integer producedQuantity;
	@ApiModelProperty("步骤完成时间")
	private Timestamp finishTime;
	
	@ApiModelProperty("生产计划单")
	private Plan plan;
	
	public Process() {
		super();
	}
	
	public boolean isFinished() {
		return finishTime != null;
	}

	public Process(String id, String status, String createdBy, Integer step, Integer demandQuantity,
			Plan plan) {
		super(id, status, createdBy);
		this.step = step;
		this.demandQuantity = demandQuantity;
		this.plan = plan;
	}

	public Process(String id, String status, String isDeleted, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy, String no, Integer step, Timestamp materialArrivetime,
			Integer demandQuantity, Integer producedQuantity, Timestamp finishTime, Plan plan) {
		super(id, status, isDeleted, createdTime, createdBy, modifiedTime, modifiedBy);
		this.no = no;
		this.step = step;
		this.materialArriveTime = materialArrivetime;
		this.demandQuantity = demandQuantity;
		this.producedQuantity = producedQuantity;
		this.finishTime = finishTime;
		this.plan = plan;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Timestamp getMaterialArrivetime() {
		return materialArriveTime;
	}

	public void setMaterialArrivetime(Timestamp materialArrivetime) {
		this.materialArriveTime = materialArrivetime;
	}

	public Integer getDemandQuantity() {
		return demandQuantity;
	}

	public void setDemandQuantity(Integer demandQuantity) {
		this.demandQuantity = demandQuantity;
	}

	public Integer getProducedQuantity() {
		return producedQuantity;
	}

	public void setProducedQuantity(Integer producedQuantity) {
		this.producedQuantity = producedQuantity;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Timestamp getMaterialArriveTime() {
		return materialArriveTime;
	}

	public void setMaterialArriveTime(Timestamp materialArriveTime) {
		this.materialArriveTime = materialArriveTime;
	}

	@Override
	public String toString() {
		return "Process [no=" + no + ", step=" + step + ", materialArriveTime=" + materialArriveTime
				+ ", demandQuantity=" + demandQuantity + ", producedQuantity=" + producedQuantity + ", finishTime="
				+ finishTime + ", plan=" + plan + "]";
	}
}
