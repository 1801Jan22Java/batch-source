package com.revature.bbeans;


public class BankUserAccount {
	private BankUser owner;
	private BankAccount account;
	
	public BankUserAccount() {
		super();
	}
	
	public BankUserAccount(BankUser owner, BankAccount account) {
		this.owner = owner;
		this.account = account;
	}
	
	public BankUser getOwner() {
		return owner;
	}
	
	public BankAccount getAccount() {
		return account;
	}
}
