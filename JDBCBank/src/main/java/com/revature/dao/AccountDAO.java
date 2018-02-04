package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.exceptions.NegativeAmountException;

public interface AccountDAO {
	public void createAcount(Account acct, int userId);
	public List<Account> getAccounts();
	public Account getAccountById(int acctId);
	public List<Account> getAccountsByUserId(int userId);
	public void depositAmount(int acctId, int amount) throws NegativeAmountException;
	public void withdrawAmount(int acctId, int amount) throws NegativeAmountException;
	public void deleteAccount(int acctId);
	public void updateAccount(Account acct);
	
	
}
