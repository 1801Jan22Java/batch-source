package com.revature.beans;

import java.util.*;

public class User {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean superUser;
	private List<Account> accounts;
	private int id;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String userName, 
			String password, boolean superUser, List<Account> accounts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.superUser = superUser;
		this.accounts = accounts;
	}
	
	public User(int id, String firstName, String lastName, String userName, 
			String password, boolean superUser, List<Account> accounts) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.superUser = superUser;
		this.accounts = accounts;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuperUser() {
		return superUser;
	}

	public void setSuperUser(boolean superUser) {
		this.superUser = superUser;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String rtnStr = "";
		rtnStr += id + " " + firstName + " " + lastName + " " + userName + " " + password + "\n";
		
		if (accounts.isEmpty()) {
			rtnStr += "  No Accounts.\n";  
		}else {
			for (Account act : accounts) {
				rtnStr += "  " + act.toString() + "\n";
			}
		}
			
		return rtnStr;
	}
	
}
