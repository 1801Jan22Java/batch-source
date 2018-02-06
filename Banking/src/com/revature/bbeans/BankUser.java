package com.revature.bbeans;

public class BankUser {
	private int userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public BankUser() {
		super();
	}
	
	public BankUser(int userID, String first, String last) {
		this.userID    = userID;
		this.firstName = first;
		this.lastName  = last;
	}
	
	public BankUser(int userID, String first, String last, String username, String password) {
		this.userID    = userID;
		this.firstName = first;
		this.lastName  = last;
		this.username  = username;
		this.password  = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
}
