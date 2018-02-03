package com.revature.beans;

import com.revature.util.*;

enum AccountTypes {
		Checking, Savings, IRA, Brokerage, Money_Market
	}

public class Account {
	public Account(Double balance, double interestRate, Boolean isEmpty) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.isEmpty = isEmpty;
	}
	
	public Account() {
		super();
		balance = 0.0;
		interestRate = 0.0;
		isEmpty = true;
	}
	
	private Double balance;
	private double interestRate;
	private Boolean isEmpty;
	
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
	
	
}
