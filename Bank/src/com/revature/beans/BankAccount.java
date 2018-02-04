package com.revature.beans;

public class BankAccount {
	
	private int accountID;
	private float currentBalance;
	
	/**
	 * No args constructor 
	 */
	public BankAccount() 
	{
		super();
	}

	/**
	 * constructor that creates a BankAccount with a currentBalance
	 * @param currentBalance
	 */
	public BankAccount(float currentBalance) 
	{
		super();
		this.currentBalance = currentBalance;
	}
	
	/**
	 * constructor that creates a BankAccount with a currentBalance and id
	 * @param accountID
	 * @param currentBalance
	 */
	public BankAccount(int accountID, float currentBalance) 
	{
		super();
		this.accountID = accountID;
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() 
	{
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) 
	{
		this.accountID = accountID;
	}

	/**
	 * @return the currentBalance
	 */
	public float getCurrentBalance() 
	{
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(float currentBalance) 
	{
		this.currentBalance = currentBalance;
	}

}
