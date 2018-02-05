package com.revature.beans;

import java.time.LocalDate;

public class User {

	public User(String userName, String password, String firstName, String lastName, LocalDate birthday, String email,
			LocalDate dayRegistered, int active) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.dayRegistered = dayRegistered;
		this.active = active;
	}

	public User(int userID, String userName, String password, String firstName, String lastName, LocalDate birthday,
			String email, LocalDate dayRegistered, int active) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.dayRegistered = dayRegistered;
		this.active = active;
	}

	public User() {
		
	}

	private int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;
	private LocalDate dayRegistered;
	private int active;

	public String getUserName() {
		return userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getUserID() {
		return userID;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public LocalDate getDayRegistered() {
		return dayRegistered;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Username: " + userName + " firstName=" + firstName + ", lastName=" + lastName;
	}

}
