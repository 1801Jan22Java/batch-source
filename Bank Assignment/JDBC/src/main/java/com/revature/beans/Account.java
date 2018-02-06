package com.revature.beans;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;

public class Account {
	private int accountID;
	private double balance;
	
	public Account(int accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}


	public void updateBalance() {
		AccountDao dao = (AccountDao) new AccountDaoImpl();
		balance = dao.updateBalance(this);
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	
}
