package com.revature.dao;

import java.util.List;

import com.revature.beans.Accounts;

public interface AccountsDao {
	public List<Accounts> getAccounts();
	public void addFunds(double money);
	public void removeFunds(double money);
	public double getBalance();
	public void deleteAccount(int account);
	public double getBalance_Super(int account);
	public void addFunds_Super(int account,double money);
	public void removeFunds_Super(int account,double money);
	public void deleteAccount_Super(int account);
	

}
