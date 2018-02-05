package com.revature.beans;

public class Accounts {

	//Constructors
	public Accounts() {};
	
	public Accounts(int bankAccountID, int bankAccountType, float currencyAmount) {
		super();
		this.bankAccountID = bankAccountID;
		this.bankAccountType = bankAccountType;
		this.currencyAmount = currencyAmount;
	}
	
	//Variables
	private int bankAccountID;
	private int bankAccountType;
	private float currencyAmount;
	
	//Getters and Setters
	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public int getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(int bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	public float getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(float currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	//toString
	@Override
	public String toString() {
		/*
		return "Accounts [bankAccountID=" + bankAccountID + ", bankAccountType=" + bankAccountType + ", currencyAmount="
				+ currencyAmount + "]";
				*/
		String accountType;
		if (bankAccountType == 4)
			accountType = "Savings";
		else accountType = "Checking";
		
	
		return String.format("Account ID: %d       Account Type: %s      Current Holdings: $ %.2f%n", bankAccountID, accountType, currencyAmount);
		
	}
}
