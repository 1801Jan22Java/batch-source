package com.revature.beans;

public class Account {
	
	//Private fields
	
	private int bankAccountId;
	private double balance;
	private int userId;
	
	
	//Constructors 
	
	public Account() {
		
	}
	
	public Account(int bankAccountId, double balance, int userId) {
		super();
		this.bankAccountId = bankAccountId;
		this.balance = balance;
		this.userId = userId;
	}
	
	
	//Getters and Setters
	
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
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
	
	
}
