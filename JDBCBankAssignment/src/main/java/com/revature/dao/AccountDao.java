package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {
	public List<Account> getAccounts(User owner);
	public void createAccount(User owner);
	public void deposit(User owner, Account account, float amount);
	public void withdraw(User owner, Account account, float amount);
	
}
