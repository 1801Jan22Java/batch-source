package com.revature.beans;

public class Manager {

	private int mgrId;
	private String fname;
	private String lname;
	private String username;
	private String password;

	public Manager(int mgrId, String fname, String lname, String username, String password) {
		this.mgrId = mgrId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}

	public Manager(String fname, String lname, String username, String password) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	
	public Manager() {}

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

	public int getMgrId() {
		return mgrId;
	}

	@Override
	public String toString() {
		return "{ \"mgrId\" : " + mgrId + ", \"fname\" : \"" + fname + "\", \"lname\" : \"" + lname + "\", \"username\" : \"" + username
				+ "\", \"password\" : \"" + password + "\" }";
	}
	
}
