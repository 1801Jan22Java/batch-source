package com.revature.beans;

public class Employee {
	private int employeeId;
	private String username;
	private String password;
	private int employeeInformationId;
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeId, String username, String password, int employeeInformationId) {
		super();
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		this.employeeInformationId = employeeInformationId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmployeeInformationId() {
		return employeeInformationId;
	}
	public void setEmployeeInformationId(int employeeInformationId) {
		this.employeeInformationId = employeeInformationId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", employeeInformationId=" + employeeInformationId + "]";
	}

}
