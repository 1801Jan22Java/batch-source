package com.revature.beans;

import java.sql.Connection;
import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private int userID;
	private Connection conn;
	private ArrayList<Account> accounts;

	// class for storing the username and password of a User
	// also stores the Connection being used by that User
	// also stores an ArrayList of the user's accounts
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
}
