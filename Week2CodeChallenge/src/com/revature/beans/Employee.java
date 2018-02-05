package com.revature.beans;

public class Employee {

	public Employee(String firstName, String lastName, int departmentID, int salary, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentID = departmentID;
		this.salary = salary;
		this.email = email;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	private String firstName;
	private String lastName;
	private int departmentID;
	private int salary;
	private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
