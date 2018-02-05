package com.revature.beans;

public class UserAccounts {

	//Constructors
	public UserAccounts() {}
		
	public UserAccounts(int userID, int bankAccountID) {
		super();
		this.userID = userID;
		this.bankAccountID = bankAccountID;
	}
	
	//Variables
	private int userID;
	private int bankAccountID;
	
	//Getters and Setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	//toString
	@Override
	public String toString() {
		return "UserAccounts [userID=" + userID + ", bankAccountID=" + bankAccountID + "]";
	}
	
	
	
}
