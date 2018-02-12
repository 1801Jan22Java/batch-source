package com.revature.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee {
	public Employee(int employeeId, String firstname, String lastname, String email, String jobTitle,
			LocalDate creationDate, Employee reportsTo) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.jobTitle = jobTitle;
		this.creationDate = creationDate;
		this.reportsTo = reportsTo;
	}
	public Employee(int employeeId, String firstname, String lastname, String email, String jobTitle,
			LocalDate creationDate) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.jobTitle = jobTitle;
		this.creationDate = creationDate;
	}
	private int employeeId;
	private String firstname;
	private String lastname;
	private String email;
	private String jobTitle;
	private LocalDate creationDate;
	private Employee reportsTo = null;
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Request> requests = new ArrayList<>();
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public Employee getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public ArrayList<Request> getRequests() {
		return requests;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", jobTitle=" + jobTitle + ", creationDate=" + creationDate;
	}

}
