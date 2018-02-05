package com.revature.beans;

public class BankAccount {
	
	private int accountID;
	private double currentBalance;
	private int accountType;
	
	/**
	 * No args constructor 
	 */
	public BankAccount() 
	{
		super();
	}
	
/**
 * 
 * @param currentBalance
 * @param accountType
 */
	public BankAccount(double currentBalance, int accountType) {
		super();
		this.currentBalance = currentBalance;
		this.accountType = accountType;
	}

	
	/**
	 * 
	 * @param accountID
	 * @param currentBalance
	 * @param accountType
	 */
	public BankAccount(int accountID, double currentBalance, int accountType) 
	{
		super();
		this.accountID = accountID;
		this.currentBalance = currentBalance;
		this.accountType = accountType;
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
	public double getCurrentBalance() 
	{
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) 
	{
		this.currentBalance = currentBalance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAccount [accountID=" + accountID + ", currentBalance=" + currentBalance + "]";
	}

	/**
	 * @return the accountType
	 */
	public int getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	
}
