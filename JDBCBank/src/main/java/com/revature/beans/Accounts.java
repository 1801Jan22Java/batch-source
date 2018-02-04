package com.revature.beans;

public class Accounts {
	private int accountId;
	private String accountType;
	private int userId;
	private double balance;

	public Accounts(int accountId, String accountType, int userId, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.userId = userId;
		this.balance = balance;
	}

	public void printAccount() {
		System.out.print("AccountId: " + accountId);
		System.out.print(" AccountType: " + accountType);
		System.out.print(" Balance: " + balance + "\n");
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
