package com.revature.beans;

import java.sql.Date;
import java.util.ArrayList;

import com.revature.dao.TransactionDaoImpl;
import com.revature.util.*;

enum AccountTypes {
		Checking, Savings, IRA, Brokerage, Money_Market
	}

public class Account {
	public Account(int id, Double balance, double interestRate, Boolean isEmpty) {
		super();
		this.accountID = id;
		this.balance = balance;
		this.interestRate = interestRate;
		this.isEmpty = isEmpty;
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
	private Double balance;
	private double interestRate;
	private Boolean isEmpty;
	private Date creationDate;
	private ArrayList<Transaction> transactions;
	
	public void deposit(Double amount) throws RuntimeException{
		
		if(amount < 0.0) {
			throw new RuntimeException("Invalid Deposit Amount!");
		}
		
		
	}
	
	public ArrayList<Transaction> getTransactions() {
		TransactionDaoImpl t = new TransactionDaoImpl();
		ArrayList<Transaction> money = t.getTransactions(this);
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

	public Date getCreationDate() {
		return creationDate;
	}
	
	
}
