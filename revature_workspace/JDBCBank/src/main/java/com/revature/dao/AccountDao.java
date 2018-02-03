package com.revature.dao;

import java.util.List;

import Beans.Account;

public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccountById();

}
