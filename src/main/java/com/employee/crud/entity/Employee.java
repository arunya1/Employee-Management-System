package com.employee.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employeerecord")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	private String employeeName;
	private String employeeId;
	private int age;
	private String employeeDesignation;
	private long employeePhoneNo;
	private String employeeAddress;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public long getEmployeePhoneNo() {
		return employeePhoneNo;
	}
	public void setEmployeePhoneNo(long employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeId=" + employeeId + ", age=" + age
				+ ", employeeDesignation=" + employeeDesignation + ", employeePhoneNo=" + employeePhoneNo
				+ ", employeeAddress=" + employeeAddress + "]";
	}
	

	
	
}
