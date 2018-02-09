package com.revature.beans;

public class Employee {

	public Employee(int employeeID, String firstName, String lastName, String email, int reportsTo, String phone,
			String jobTitle, int active) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.reportsTo = reportsTo;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.active = active;
	}
	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private String email;
	private int reportsTo;
	private String phone;
	private String jobTitle;
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

}
