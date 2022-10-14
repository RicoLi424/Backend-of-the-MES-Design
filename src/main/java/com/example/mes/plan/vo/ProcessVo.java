package com.example.mes.plan.vo;

import com.example.mes.plan.entity.Plan;
import com.example.mes.plan.entity.Process;

import java.sql.Timestamp;

public class ProcessVo  {
	private Process process = new Process();
	

	public ProcessVo() {
		super();
	}

	public ProcessVo(Process process) {
		super();
		this.process = process;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
	
	public String getNo() {
		return process.getNo();
	}

	public void setNo(String no) {
		this.process.setNo(no);
	}

	public Integer getStep() {
		return process.getStep();
	}

	public void setStep(Integer step) {
		this.process.setStep(step);
	}

	public Timestamp getMaterialArrivetime() {
		return process.getMaterialArrivetime();
	}

	public void setMaterialArrivetime(Timestamp materialArrivetime) {
		this.process.setMaterialArrivetime(materialArrivetime);
	}

	public Integer getDemandQuantity() {
		return process.getDemandQuantity();
	}

	public void setDemandQuantity(Integer demandQuantity) {
		this.process.setDemandQuantity(demandQuantity);
	}

	public Integer getProducedQuantity() {
		return process.getProducedQuantity();
	}

	public void setProducedQuantity(Integer producedQuantity) {
		this.process.setProducedQuantity(producedQuantity);
	}

	public Timestamp getFinishTime() {
		return process.getFinishTime();
	}

	public void setFinishTime(Timestamp finishTime) {
		this.process.setFinishTime(finishTime);
	}

	public Plan getPlan() {
		return process.getPlan();
	}

	public void setPlan(Plan plan) {
		this.process.setPlan(plan);
	}
	
	public String getId() {
		return process.getId();
	}

	public void setId(String id) {
		this.process.setId(id);
	}

	public String getStatus() {
		return process.getStatus();
	}

	public void setStatus(String status) {
		this.process.setStatus(status);
	}

	public String getDeleted() {
		return process.getDeleted();
	}

	public void setDeleted(String deleted) {
		this.process.setDeleted(deleted);
	}

	public Timestamp getCreatedTime() {
		return process.getCreatedTime();
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.process.setCreatedTime(createdTime);
	}

	public String getCreatedBy() {
		return process.getCreatedBy();
	}

	public void setCreatedBy(String createdBy) {
		this.process.setCreatedBy(createdBy);
	}

	public Timestamp getModifiedTime() {
		return process.getModifiedTime();
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.process.setModifiedTime(modifiedTime);
	}

	public String getModifiedBy() {
		return process.getModifiedBy();
	}

	public void setModifiedBy(String modifiedBy) {
		this.process.setModifiedBy(modifiedBy);
	}
	
	public Timestamp getMaterialArriveTime() {
		return this.process.getMaterialArriveTime();
	}

	public void setMaterialArriveTime(Timestamp materialArriveTime) {
		this.process.setMaterialArriveTime(materialArriveTime);
	}
}
