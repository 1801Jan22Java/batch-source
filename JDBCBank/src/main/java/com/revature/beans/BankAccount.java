package com.revature.beans;

public class BankAccount {
	
	public BankAccount() {
		super();
	}

	public BankAccount(int id, double balance, User user, String accountType) {
		super();
		this.id = id;
		this.balance = balance;
		this.user = user;
		this.accountType = accountType;
	}

	private int id;
	private double balance;
	private User user;
	private String accountType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getbalance() {
		return balance;
	}
	public void setbalance(double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	// Don't want to show all of the user information
	public String toString() {
		return "BankAccount [id=" + id + ", balance=" + balance + ", user=" + user.getUsername() + ", accountType="
				+ accountType + "]";
	}
	
}
