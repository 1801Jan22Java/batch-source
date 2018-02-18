package com.revature.beans;

public class Employee {

	private int empId;
	private String fname;
	private String lname;
	private String job;
	private String username;
	private String password;

	public Employee(int empId, String fname, String lname, String job, String username, String password) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		this.username = username;
		this.password = password;
	}

	public Employee(String fname, String lname, String job, String username, String password) {
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		this.username = username;
		this.password = password;
	}
	
	public Employee() {}

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	public int getEmpId() {
		return empId;
	}

	@Override
	public String toString() {
		return "{ \"empId\" : \"" + empId + "\", \"fname\" : \"" + fname + "\", \"lname\" : \"" + lname + "\", \"job\" : \"" + job + "\", \"username\" : \""
				+ username + "\", \"password\" : \"" + password + "\" }";
	}
	
}
