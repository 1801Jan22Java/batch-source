package com.revature.beans;

public class Employee {
	private int employeeID;
	private String username;
	private String password;
	private String fName;
	private String lName;
	private String email;
	private int isManager;
	
	public Employee(int employeeID, String username, String password, String fName, String lName, String email,
			int isManager) {
		super();
		this.employeeID = employeeID;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.isManager = isManager;
	}
	public Employee() {
		super();
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
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public int isManager() {
		return isManager;
	}
}
