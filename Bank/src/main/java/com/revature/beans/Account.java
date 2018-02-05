package com.revature.beans;

import java.time.LocalDate;

public class Account {
	public Account() {
		super();
	}
	public Account(int accountid, String account_type, String name, float balance) {
		super();
		this.accountid = accountid;
		this.accountType = account_type;
		this.balance = balance;
		this.name = name;
	}
	private int accountid;
	private String accountType;
	private float balance = 0f;
	private LocalDate creation_date;
	private String name = "noname";
	
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public LocalDate getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	@Override
	public String toString() {
		return accountType + " Account \"" + name + "\": " + accountid + ", has a balance of $" + balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
