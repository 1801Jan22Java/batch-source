package com.revature.beans;

public class Employee {

	public Employee(String firstName, String lastName, String email, String password, int reportsTo, String phone,
			String jobTitle, boolean isManager, int active) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.reportsTo = reportsTo;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.isManager = isManager;
		this.active = active;
	}
	public Employee(int employeeID, String firstName, String lastName, String email, String password, int reportsTo, String phone,
			String jobTitle, boolean manager, int active) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.reportsTo = reportsTo;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.isManager = manager;
		this.active = active;
	}
	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private String email;
	private String password;
	private int reportsTo;
	private String phone;
	private String jobTitle;
	private boolean isManager;
	private int active;
	
	
	public int getEmployeeID() {
		return EmployeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getEmail() {
		return email;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public String getPhone() {
		return phone;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public int getActive() {
		return active;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
