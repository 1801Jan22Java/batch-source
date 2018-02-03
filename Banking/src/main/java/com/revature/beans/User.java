package com.revature.beans;

public class User {
	
	//Constructors
	
	public User() {
		
	}
	
	public User(String username, String firstName, String lastName, int userId, boolean superUser) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.superUser = superUser;
	}
	
	
	//Private fields
	
	private String username;	//Won't store passwords in Java.
	private String firstName;
	private String lastName;
	private int userId;
	private boolean superUser;
	
	
	//Getters and Setters
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
