package com.revature.beans;

public class User {
	
	private int id;
	private String username;
	private String password;
	private boolean isSuperUser;
	
	public User(int id, String username, String password, boolean isSuperUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.setSuperUser(isSuperUser);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isSuperUser() {
		return isSuperUser;
	}

	public void setSuperUser(boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}
	
}
