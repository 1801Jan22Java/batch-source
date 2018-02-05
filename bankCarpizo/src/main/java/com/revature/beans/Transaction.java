package com.revature.beans;

import java.time.LocalDate;

public class Transaction 
{
	private int id;
	private BankAccount account;
	private LocalDate dateOfTransaction;
	private TransactionType type;
	private float amount;
	private float balance;
	
	public Transaction() {}
	
	public Transaction(BankAccount account, LocalDate dateOfTransaction, TransactionType type, float amount, float balance)
	{
		this.account = account;
		this.dateOfTransaction = dateOfTransaction;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	public Transaction(int id, BankAccount account, LocalDate dateOfTransaction, TransactionType type, float amount, float balance)
	{
		this.id = id;
		this.account = account;
		this.dateOfTransaction = dateOfTransaction;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public BankAccount getAccount()
	{
		return account;
	}

	public void setAccount(BankAccount account)
	{
		this.account = account;
	}

	public LocalDate getDateOfTransaction()
	{
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction)
	{
		this.dateOfTransaction = dateOfTransaction;
	}

	public TransactionType getType()
	{
		return type;
	}

	public void setType(TransactionType type)
	{
		this.type = type;
	}
	
	public float getAmount() 
	{
		return amount;
	}

	public void setAmount(float amount) 
	{
		this.amount = amount;
	}

	public float getBalance() 
	{
		return balance;
	}

	public void setBalance(float balance) 
	{
		this.balance = balance;
	}

	public String toString()
	{
		if(id!=0)
			return "Transaction Info:\n\tAccount: " + account.getUser() +"\n\tDate of Transaction: " + dateOfTransaction.toString() + "\n\tType: " + type + "\n\tAmount: " + amount + "\n\tBalance: " + balance;
		else
			return "Transaction Info:\n\tTransaction ID: " + id + "\n\tAccount: " + account.getUser() +"\n\tDate of Transaction: " + dateOfTransaction.toString() + "\n\tType: " + type + "\n\tAmount: " + amount + "\n\tBalance: " + balance;

	}
}
