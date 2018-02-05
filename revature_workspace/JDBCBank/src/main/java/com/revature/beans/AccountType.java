package com.revature.beans;

public class AccountType {
	private int accountTypeID;
	private String accountType;
	public AccountType(){}
	public AccountType(int accountTypeID,String accountType)
	{
		this.accountTypeID=accountTypeID;
		this.accountType=accountType;
	}
	public int getAccountTypeID() {
		return accountTypeID;
	}
	
	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
