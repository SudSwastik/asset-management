package com.sudarshan.sud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "Employee Name is mandatory field")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "Employee Id should be alpha numeric")
	private String employeeId;
	
	@Pattern(regexp = "[a-zA-Z]*", message = "Only alphabets allowed")
	private String employeeSurname;
	
	
	@NotEmpty(message = "Employee Name is mandatory field")
	@Pattern(regexp = "[a-zA-Z]*", message = "Only alphabets allowed")
	private String employeeName;
	
	@Pattern(regexp = "[0-9][0-9]{9}", message = "invalid mobile number.")
	private String mobileNumber;
	
	@Pattern(regexp = "[a-zA-Z]*", message = "Only alphabets allowed")
	private String location;
	
	@Pattern(regexp = "[a-zA-Z]*", message = "Only alphabets allowed")
	private String designation;
	
	public Employee() {
		
	}
	public Employee(String employeeId, String employeeSurname, String employeeName, String mobileNumber, String location,
			String designation) {
		super();
		this.employeeId = employeeId;
		this.employeeSurname = employeeSurname;
		this.employeeName = employeeName;
		this.mobileNumber = mobileNumber;
		this.location = location;
		this.designation = designation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeSurname() {
		return employeeSurname;
	}
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
