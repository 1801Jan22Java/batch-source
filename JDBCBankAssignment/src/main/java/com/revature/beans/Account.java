package com.revature.beans;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;

public class Account {
	
	private int accountID;
	private String accountName;
	private float balance;
	
	public Account(int accountID, String accountName, float balance) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.balance = balance;
	}

	//Updates balance from database
	public void updateBalance() {
		AccountDao dao = new AccountDaoImpl();
		balance = dao.updateBalance(this);
	}
	
	public float deposit() {
		return 0;
	}
	
	public float withdraw() {
		return 0;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public float getBalance() {
		return this.balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}
