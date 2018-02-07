package com.revature.beans;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;

public class Account {
	private int accountID;
	private long balance;
	
	public Account(int accountID, long balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}




	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public long getBalance() {
		return this.balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	
}
