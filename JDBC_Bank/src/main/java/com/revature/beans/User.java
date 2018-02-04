package com.revature.beans;
 
import java.time.LocalDate;


public class User {

	public User(int userID, Credentials credentials, String firstName, String lastName, LocalDate birthday, String email,
			LocalDate dayRegistered, int active) {
		super();
		this.userID = userID;
		this.credentials = credentials;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.dayRegistered = dayRegistered;
		this.active = active;
	}
	private int userID;
	private Credentials credentials;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;
	private LocalDate dayRegistered;
	private int active;
	
	public String getUserName() {
		return credentials.getUsername();
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
	public Credentials getCredentials() {
		return credentials;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public LocalDate getDayRegistered() {
		return dayRegistered;
	}

	public String getPassword() {
		return credentials.getPassword();
	}

}
