package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Accounts;
import com.revature.util.OverDraftException;

//Abstract out account operations 
public interface AccountDAO {

	// Throw custom exception for username already exists
	public boolean newAccount(int userId, int accountType);
	
	// Delete an account
	public boolean deleteAccount(int userId, int accountId);

	// Display accounts
	public ArrayList<Accounts> getAccounts(Integer userid) ;


	// Deposit money to account
	public boolean deposit(Integer userid, Integer accountid, Double amount);

	public boolean withdraw(Integer userid, Integer accountid, Double amount) throws OverDraftException;
	

}
