package com.revature.beans;

import java.util.ArrayList;
public class BankAccount 
{
	private int id;
	private User user;
	private float balance;
	private AccountType type;
	ArrayList<Transaction> transactions;

	public BankAccount() {}

	public BankAccount(User user, float balance, AccountType type, ArrayList<Transaction> transactions)
	{
		this.user = user;
		this.balance = balance;
		this.type = type;
		this.transactions = transactions;
	}

	public BankAccount(int id, User user, float balance, AccountType type, ArrayList<Transaction> transactions)
	{
		this.id = id;
		this.user = user;
		this.balance = balance;
		this.type = type;
		this.transactions = transactions;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public float getBalance()
	{
		return balance;
	}

	public void setBalance(float balance)
	{
		this.balance = balance;
	}

	public AccountType getType()
	{
		return type;
	}

	public void setType(AccountType type) 
	{
		this.type = type;
	}
	
	public ArrayList<Transaction> getTransactions() 
	{
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) 
	{
		this.transactions = transactions;
	}

	public String toString()
	{
		if(id!=0)
			return "Bank Account Info:\n\tUser: " + user.getUsername() + "\n\tBalance: " + balance + "\n\tType: " + type + "\n\tTransactions: " + transactions;
		else
			return "Bank Account Info:\n\tUser ID: " + id + "\n\tUser: " + user.getUsername() + "\n\tBalance: " + balance + "\n\tType: " + type + "\n\tTransactions: " + transactions;

	}
}
