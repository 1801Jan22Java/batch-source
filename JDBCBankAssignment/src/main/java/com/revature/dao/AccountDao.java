package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.OverdraftException;

public interface AccountDao {
	public List<Account> getAccounts(User owner);
	public float updateBalance(Account account);
	public void createAccount(User owner, String accountName);
	public void deleteAccount(Account account);
	public void deposit(User owner, Account account, float amount);
	public void withdraw(User owner, Account account, float amount) throws OverdraftException;
	
}
