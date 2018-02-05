package com.revature.beans;

import com.revature.Exceptions.ZeroBalanceException;

public abstract class Account {
	public float initialBalance;
	public AccountType accountType;
	public int userId;
	public Account(){}
	public Account (float initialBalance, int userID) throws ZeroBalanceException
	{
		try{
			if(initialBalance<1)
			{ 
				throw new ZeroBalanceException("Your initial balance cannot be less than zero.");
			
			}
			else{
				this.initialBalance=initialBalance;
				this.userId=userID;
			
			}
			}
			catch(ZeroBalanceException e)
			{
				e.printStackTrace();
			}

	}
	public Account(float initialBalance,
			AccountType accountType,int userID)
	{
		
		this.initialBalance=initialBalance;
		this.accountType=accountType;
		this.userId=userID;
	}
	
	 public abstract void deposit(float funds);
	 public abstract void withdraw(float withdrawal);
	 public abstract float getBalance();
	 public abstract void displayBalance();
	 public abstract void closeAccount();
	 public abstract AccountType getAccountType();

}
