package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;


public class Product extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486547169449396700L;
	private String brand;
	private String style;
	private String color;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private String company;
	private String season;
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	
	
}
