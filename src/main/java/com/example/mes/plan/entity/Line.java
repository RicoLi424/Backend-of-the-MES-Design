package com.example.mes.plan.entity;

import com.example.mes.plan.common.BaseEntity;

public class Line extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5817295606524127176L;
	
	private String name;
	private String workshopId;
	private String workshopName;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getWorkshopName()
	{
		return workshopName;
	}
	
	public void setWorkshopName(String workshopName)
	{
		this.workshopName = workshopName;
	}

	public String getWorkshopId()
	{
		return workshopId;
	}
	private String uuid;
	public String getUuid()
	{
		return uuid;
	}
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	public void setWorkshopId(String workshopId)
	{
		this.workshopId = workshopId;
	}
	
}
