package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
	
	public String filename = "connection.properties";
	
	public List<Account> getAccount();
	public Account getAccountByID(int id);
	public void addAccount(int userid, int type, double initialAmount);

}
