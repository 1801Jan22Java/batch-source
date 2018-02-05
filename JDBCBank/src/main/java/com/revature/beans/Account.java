package com.revature.beans;

// class to store the AccountID and Balance for accounts queried with the ViewAccounts method in UserDaoImpl
public class Account {
	private int accountID;
	private double balance;

	public Account(int accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "[accountID=" + accountID + ", balance=" + balance + "]";
	}
}
