package com.revature.beans;

import com.revature.Exceptions.ZeroBalanceException;


public class CheckingAccount extends Account {

	AccountType accountType = new AccountType(2,"Checking");
	
	public CheckingAccount(float initialBalance, int userId) 
	{
		super(initialBalance,userId);
		super.accountType=accountType;
		

	}
	@Override
	public void deposit(float funds) {
		initialBalance+=funds;
		
	}

	@Override
	public void withdraw(float withdrawal) {
		initialBalance-=withdrawal;
	
	}

	@Override
	public void displayBalance() {
		System.out.println(initialBalance);
		
	}

	@Override
	public void closeAccount() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public AccountType getAccountType() {
		return accountType;
	}
	@Override
	public float getBalance() {
		// TODO Auto-generated method stub
		return initialBalance;
	}

}
