package com.revature.jdbcbacnk;

public class Bank {

	private String username;
	private String password;
	private double balance;
	private double account;
	private int transaction;
	
	
	public Bank(String mUsername, String mPassword, double mBalance, double mAccount, int mTransaction){
		{
			username = mUsername;
			password = mPassword;
			balance = mBalance;
			account = mAccount;
			transaction = mTransaction;
	}
		
		
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getAccount() {
		return account;
	}


	public void setAccount(double account) {
		this.account = account;
	}


	public int getTransaction() {
		return transaction;
	}


	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	public void delete() {
		if(account == 0) {
			System.out.println("The account is now deleted.");
		}
		else {
			System.out.println("The account is still active.");
		}
	}
	
}
