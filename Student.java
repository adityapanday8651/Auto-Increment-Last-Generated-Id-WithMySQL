package com.comp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private int studentId;
	private String name;
	private String rollNo;
	private String course;
	private String session;
	private double fees;
	
	public String getCourse() {
		return course;
	}
	public String getSession() {
		return session;
	}
	public double getFees() {
		return fees;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getId() {
		return id;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", name=" + name + ", rollNo=" + rollNo + ", course="
				+ course + ", session=" + session + ", fees=" + fees + "]";
	}
}
