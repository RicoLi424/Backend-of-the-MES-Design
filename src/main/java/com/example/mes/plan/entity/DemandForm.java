package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@ApiModel(value = "edu.sdu.mes.plan.entity.DemandForm", description = "客户需求单")
public class DemandForm extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5634466439564620073L;

	@ApiModelProperty("单号")
	private String no = "";

	@ApiModelProperty("所需数量")
	private Integer quantity;
	@ApiModelProperty("交付时间")
	private Date expectedDate;
	@ApiModelProperty("批阅时间")
	private Timestamp readTime;
	@ApiModelProperty("是否需要操作")
	private Boolean waiting;

	@ApiModelProperty("指向原版需求单")
	private DemandForm originalDemandForm;
	@ApiModelProperty("产品类型")
	private Product product; // unknown class

	@ApiModelProperty("生产计划单合集")
	private Set<Plan> planSet;

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	@ApiModelProperty("公司号")
	private String company_id;
	
//	无法做到
//	@ApiModelProperty("历史修改版本")
//	private List<DemandForm> othersList;

	public DemandForm() {
		super();
	}

	public DemandForm(String id, String status, String createdBy, Integer quantity, Date expectedDate,
		Boolean waiting, Product product) {
	super(id, status, createdBy);
	this.quantity = quantity;
	this.expectedDate = expectedDate;
	this.waiting = waiting;
	this.product = product;
}
	
	public DemandForm(String id, String status, String isDeleted, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy, String no, Integer quantity, Date expectedDate,
			Timestamp readTime, Boolean waiting, DemandForm originalDemandForm, Product product, Set<Plan> planSet) {
		super(id, status, isDeleted, createdTime, createdBy, modifiedTime, modifiedBy);
		this.no = no;
		this.quantity = quantity;
		this.expectedDate = expectedDate;
		this.readTime = readTime;
		this.waiting = waiting;
		this.originalDemandForm = originalDemandForm;
		this.product = product;
		this.planSet = planSet;
	}


	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Timestamp getReadTime() {
		return readTime;
	}

	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}

	public Boolean getWaiting() {
		return waiting;
	}

	public void setWaiting(Boolean waiting) {
		this.waiting = waiting;
	}

	public DemandForm getOriginalDemandForm() {
		return originalDemandForm;
	}

	public void setOriginalDemandForm(DemandForm originalDemandForm) {
		this.originalDemandForm = originalDemandForm;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Plan> getPlanSet() {
		return planSet;
	}

	public void setPlanSet(Set<Plan> planSet) {
		this.planSet = planSet;
	}
	
	

//	public List<DemandForm> getOthersList() {
//		return othersList;
//	}
//
//	public void setOthersList(List<DemandForm> othersList) {
//		this.othersList = othersList;
//	}

	/////////?????????????????????????????????????????????????????????????????????????????????/
	public boolean isApplyingDeletion() {
		return this.originalDemandForm!=null && "0".equals(originalDemandForm.getId()) && this.readTime == null;
	}

	@Override
	public String toString() {
		return "DemandForm [no=" + no + ", quantity=" + quantity + ", expectedDate=" + expectedDate + ", readTime="
				+ readTime + ", waiting=" + waiting + ", originalDemandForm=" + originalDemandForm + ", product="
				+ product + ", planSet=" + planSet + ", getId()=" + getId()
				+ ", getStatus()=" + getStatus() + ", getIsDeleted()=" + getDeleted() + ", getCreatedTime()="
				+ getCreatedTime() + ", getCreatedBy()=" + getCreatedBy() + ", getModifiedTime()=" + getModifiedTime()
				+ ", getModifiedBy()=" + getModifiedBy() + ", getCompany_id()=" + getCompany_id() + "]";
	}

}
