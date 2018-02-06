package com.revature.beans;

public class Admin extends User {

	private String username;
	private String password;
	
	
	// A superuser can view, create , update, and delete all users
	
	
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

	public Admin() {
		super();
	}
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}	
	
}
