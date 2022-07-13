package com.comp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IdConfig {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int lastGeneratedId;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getLastGeneratedId() {
		return lastGeneratedId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastGeneratedId(int lastGeneratedId) {
		this.lastGeneratedId = lastGeneratedId;
	}
	@Override
	public String toString() {
		return "IdConfig [id=" + id + ", name=" + name + ", lastGeneratedId=" + lastGeneratedId + "]";
	}
}
