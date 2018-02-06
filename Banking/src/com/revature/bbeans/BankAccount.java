package com.revature.bbeans;

public class BankAccount {
	public enum AccountType { Checking, Savings };
	
	private int accountID;
	private int userID;
	private double balance;
	private AccountType accountType;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(int accountID, int userID, double balance, AccountType accountType) {
		this.accountID   = accountID;
		this.userID      = userID;
		this.balance     = balance;
		this.accountType = accountType;
	}

	public int getAccountID() {
		return accountID;
	}

	public int getUserID() {
		return userID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
