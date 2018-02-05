package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.exceptions.OverdraftException;

public interface AccountDAO {
	public void createAcount(Account acct, int userId);

	public List<Account> getAccounts();

	public Account getAccountById(int acctId);

	public List<Account> getAccountsByUserId(int userId);

	public void depositAmount(int acctId, int amount);

	public void withdrawAmount(int acctId, int amount) throws OverdraftException;

	public void deleteAccount(int acctId);

	public void updateAccount(Account acct);

}
