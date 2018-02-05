package com.revature.beans;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
	public User() {
		super();
	}
	public User(int userid, String username, String userType, String firstname, String lastname, LocalDate creationDate) {
		super();
		this.userid = userid;
		this.username = username;
		this.userType = userType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.creationDate = creationDate;
	}
	public User(int userid, String username, String userType) {
		super();
		this.userid = userid;
		this.username = username;
		this.userType = userType;
	}
	private int userid = 0;
	private String username;
	private String userType;
	private String firstname = "<noname>";
	private String lastname = "<noname>";
	private LocalDate creationDate = null;
	private ArrayList<Account> accounts = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM, d yyyy");
		return String.format("%-12s %-20s since %10s ", "\""+username+"\"", "-"+firstname + " " + lastname, creationDate.format(formatter) );
	}
}
