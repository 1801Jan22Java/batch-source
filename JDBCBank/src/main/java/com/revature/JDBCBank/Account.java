package com.revature.JDBCBank;

// Abstract out account operations 
public class Account {

	// Throw custom exception for username already exists
	public void newAccount(String username, String password) throws UserNameExistsException {

	}
	
	// Delete an account
	public void deleteAccount(String username, String password, Integer AccountID) {
		
	}

	// Display accounts
	public String displayAccount(Integer userid) {
		return "";
	}

	// Deposit money to account
	public void deposit(Integer userid, Integer accountid, Double amount) {
		//
	}

	public Double withdraw(Integer userid, Integer accountid, Double amount) {
		return 0.0D;
	}
	

}
