package com.comp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private int id;
	private int companyId;
	private String companyName;
	private String service;
	private String location;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getService() {
		return service;
	}
	public String getLocation() {
		return location;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyId=" + companyId + ", companyName=" + companyName + ", service="
				+ service + ", location=" + location + "]";
	}
}
