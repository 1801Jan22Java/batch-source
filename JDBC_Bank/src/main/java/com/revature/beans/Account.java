package com.revature.beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.dao.TransactionDaoImpl;

enum AccountTypes {
		Checking, Savings, IRA, Brokerage, Money_Market
	}

public class Account {
	public Account(int id, Double balance, double interestRate, Boolean isEmpty, String accountName, LocalDate dayCreated) {
		super();
		this.accountID = id;
		this.balance = balance;
		this.interestRate = interestRate;
		this.isEmpty = isEmpty;
		this.transactions = this.getTransactions();
		this.accountName = accountName;
		creationDate = dayCreated;
	}
	
	public Account(int id) {
		super();
		this.accountID = id;
		this.isEmpty = true;
		this.balance = 0.0;
	}
	
	public Account(int aid, String accountType, Double amount, Double interest, LocalDate start) {
		super();
		this.accountID = aid;
		this.accountType = accountType;
		this.balance = amount;
		this.interestRate = interest;
		this.creationDate = start;
		this.transactions = this.getTransactions();
	}
	
	public Account() {
		super();
		accountID = 0;
		balance = 0.0;
		interestRate = 0.0;
		isEmpty = true;
	}
	
	

	private int accountID;
	private String accountType;
	private Double balance;
	private double interestRate;
	private Boolean isEmpty;
	private LocalDate creationDate;
	private ArrayList<Transaction> transactions;
	private String accountName; // User-friendly name for UI interactions, not the database. 
	// E.g, "John's Checking Account", "Mary's Savings account", etc. 
	
	public void deposit(Double amount) throws RuntimeException{
		
		if(amount < 0.0) {
			throw new RuntimeException("Invalid Deposit Amount!");
		}
		
		
	}
	
	public ArrayList<Transaction> getTransactions() {
		TransactionDaoImpl t = new TransactionDaoImpl();
		ArrayList<Transaction> money = t.getTransactions(this);
		// i.e, get the transactions that are associated with this instance
		return money;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getAccountID() {
		return accountID;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountType() {
		return accountType;
	}
	
	
}
