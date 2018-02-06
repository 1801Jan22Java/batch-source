package com.revature.beans;

public class Account {
	
	private int accountId;
	private int userId;
	private double balance;

	public Account() {
		super();
	}

	public Account(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public Account(int accountId, int userId, double balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}



}
