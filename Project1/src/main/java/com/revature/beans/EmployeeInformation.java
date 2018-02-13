package com.revature.beans;

public class EmployeeInformation {
	private int employeeInformationId;
	private String email;
	private String fname;
	private String lname;
	private String address;
	
	public EmployeeInformation() {
		super();
	}
	
	public EmployeeInformation(int employeeInformationId, String email, String fname, String lname, String address) {
		super();
		this.employeeInformationId = employeeInformationId;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}

	public int getEmployeeInformationId() {
		return employeeInformationId;
	}

	public void setEmployeeInformationId(int employeeInformationId) {
		this.employeeInformationId = employeeInformationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeInformation [employeeInformationId=" + employeeInformationId + ", email=" + email + ", fname="
				+ fname + ", lname=" + lname + ", address=" + address + "]";
	}

}
