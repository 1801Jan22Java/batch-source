package com.revature.dao;

import java.util.List;

import com.revature.beans.Accounts;

public interface AccountsDao {
	public List<Accounts> getAccounts();
	public void addFunds(double money);
	public void removeFunds(double money);
	public double getBalance();
	public void deleteAccount();

}
