package com.revature.dao;

import java.util.List;

import Beans.Account;

public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccountById();
	public void addAccount(Account account);
	public void deposit(float amount);
	public void withdrawal(float amount);

}
