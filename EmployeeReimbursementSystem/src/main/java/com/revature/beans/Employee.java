package com.revature.beans;

public class Employee {

	
	public Employee(int employeeID, String fName, String lName, String email, String account, String password, int isMan) {
		super();
		this.employeeID = employeeID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.account = account;
		this.password = password;
		this.isMan = isMan;
	}
	
	private int employeeID;
	private String fName;
	private String lName;
	private String email;
	private String account;
	private String password;
	private int isMan;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getisMan() {
		return isMan;
	}
	public void setisMan(int isMan) {
		this.isMan = isMan;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", account=" + account + ", password=" + password + ", isMan=" + isMan +"]";
	}
	
}
