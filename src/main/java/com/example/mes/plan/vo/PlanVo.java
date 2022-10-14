package com.example.mes.plan.vo;

import com.example.mes.plan.entity.Process;
import com.example.mes.plan.entity.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class PlanVo  {
	private Plan plan = new Plan();

	public PlanVo() {
		super();
	}

	public PlanVo(Plan plan) {
		super();
		this.plan = plan;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	public String getNo() {
		return plan.getNo();
	}

	public void setNo(String no) {
		this.plan.setNo(no);
	}

	public Integer getExpectedQuantity() {
		return plan.getExpectedQuantity();
	}

	public void setExpectedQuantity(Integer expectedQuantity) {
		this.plan.setExpectedQuantity(expectedQuantity);
	}

	public Timestamp getDistributeTime() {
		return plan.getDistributeTime();
	}

	public void setDistributeTime(Timestamp distributeTime) {
		this.plan.setDistributeTime(distributeTime);
	}

	public Line getProductionLine() {
		return plan.getProductionLine();
	}

	public void setProductionLine(Line productionLine) {
		this.plan.setProductionLine(productionLine);
	}

	public DemandForm getDemandForm() {
		return plan.getDemandForm();
	}

	public void setDemandForm(DemandForm demandForm) {
		this.plan.setDemandForm(demandForm);
	}

	public List<Process> getProcessesList() {
		return plan.getProcessesList();
	}

	public void setProcessesList(List<Process> processesList) {
		this.plan.setProcessesList(processesList);
	}
	
	public String getId() {
		return plan.getId();
	}

	public void setId(String id) {
		this.plan.setId(id);
	}

	public String getStatus() {
		return plan.getStatus();
	}

	public void setStatus(String status) {
		this.plan.setStatus(status);
	}

	public String getDeleted() {
		return plan.getDeleted();
	}

	public void setDeleted(String deleted) {
		this.plan.setDeleted(deleted);
	}

	public Timestamp getCreatedTime() {
		return plan.getCreatedTime();
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.plan.setCreatedTime(createdTime);
	}

	public String getCreatedBy() {
		return plan.getCreatedBy();
	}

	public void setCreatedBy(String createdBy) {
		this.plan.setCreatedBy(createdBy);
	}

	public Timestamp getModifiedTime() {
		return plan.getModifiedTime();
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.plan.setModifiedTime(modifiedTime);
	}

	public String getModifiedBy() {
		return plan.getModifiedBy();
	}

	public void setModifiedBy(String modifiedBy) {
		this.plan.setModifiedBy(modifiedBy);
	}

	public Set<MaterialApplication> getMaSet() {
		return this.plan.getMaSet();
	}

	public void setMaSet(Set<MaterialApplication> maSet) {
		this.plan.setMaSet(maSet);
	}

	public String getCompany_id() {
		return plan.getCompany_id();
	}

	public void setCompany_id(String company_id) {
		this.plan.setCompany_id(company_id);
	}
	
	
}
