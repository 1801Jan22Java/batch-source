package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.util.AccountNotEmptyException;

public interface AccountDao {

	public List<Account> getAccounts();
	public Account getAccountByID(int id);
	public Account addAccount();
	public void deleteAccount(Account a) throws AccountNotEmptyException;
	
}
