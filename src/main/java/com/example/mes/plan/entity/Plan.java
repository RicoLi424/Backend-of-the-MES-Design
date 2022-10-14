package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApiModel(description = "生产计划单")
public class Plan extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4067126082793224060L;

	@ApiModelProperty("单号")
	private String no = "";

	@ApiModelProperty("预期数量")
	private Integer expectedQuantity;
	@ApiModelProperty("分配时间")
	private Timestamp distributeTime;

	@ApiModelProperty("生产线")
	private Line productionLine; // unknown class
	@ApiModelProperty("需求单")
	private DemandForm demandForm;

	@ApiModelProperty("生产过程单列表")
	private List<Process> processesList = new ArrayList<>();
	@ApiModelProperty("物料申请单")
	private Set<MaterialApplication> maSet;

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	@ApiModelProperty("id")
	private  String  company_id;

	public Plan() {
		super();
	}

	public Plan(String id, String status, String createdBy, Integer expectedQuantity, Line productionLine,
			DemandForm demandForm) {
		super(id, status, createdBy);
		this.expectedQuantity = expectedQuantity;
		this.productionLine = productionLine;
		this.demandForm = demandForm;
	}

	public Plan(String id, String status, String isDeleted, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy, String no, Integer expectedQuantity, Timestamp distributeTime,
			Line productionLine, DemandForm demandForm, List<Process> processesList) {
		super(id, status, isDeleted, createdTime, createdBy, modifiedTime, modifiedBy);
		this.no = no;
		this.expectedQuantity = expectedQuantity;
		this.distributeTime = distributeTime;
		this.productionLine = productionLine;
		this.demandForm = demandForm;
		this.processesList = processesList;
	}

	public Boolean isEachProcessFinished() {
		
		for (Process process : this.processesList) {
			if (!process.isFinished()) {
				return false;
			}
		}
		return true;
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

	public Timestamp getDistributeTime() {
		return distributeTime;
	}

	public void setDistributeTime(Timestamp distributeTime) {
		this.distributeTime = distributeTime;
	}

	public Line getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(Line productionLine) {
		this.productionLine = productionLine;
	}

	public DemandForm getDemandForm() {
		return demandForm;
	}

	public void setDemandForm(DemandForm demandForm) {
		this.demandForm = demandForm;
	}

	public List<Process> getProcessesList() {
		return processesList;
	}

	public void setProcessesList(List<Process> processesList) {
		this.processesList = processesList;
	}

	public Set<MaterialApplication> getMaSet() {
		return maSet;
	}

	public void setMaSet(Set<MaterialApplication> maSet) {
		this.maSet = maSet;
	}

	@Override
	public String toString() {
		return "Plan [no=" + no + ", expectedQuantity=" + expectedQuantity + ", distributeTime=" + distributeTime
				+ ", productionLine=" + productionLine + ", demandForm=" + demandForm + ", processesList="
				+ processesList + ", maSet=" + maSet +", company_id=" + company_id + "]";
	}

}
