package com.revature.beans;

public class Account {
	
	private int accId;
	private int userId;
	private double balance;
	private String accName;
	
	public Account(int accId, int userId, double balance, String accName) {
		this.accId = accId;
		this.userId = userId;
		this.balance = balance;
		this.accName = accName;
	}
	
	public Account(int userId, double balance, String accName) {
		this.userId = userId;
		this.balance = balance;
		this.accName = accName;
	}
	
	public Account() { }

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	
	
}
