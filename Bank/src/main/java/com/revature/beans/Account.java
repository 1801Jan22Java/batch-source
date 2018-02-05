package com.revature.beans;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
	public Account() {
		super();
	}
	public Account(int accountid, String account_type, String name, float balance, LocalDate creation_date) {
		super();
		this.accountid = accountid;
		this.accountType = account_type;
		this.balance = balance;
		this.name = name;
		this.creation_date = creation_date;
	}
	private int accountid;
	private String accountType;
	private float balance = 0f;
	private LocalDate creation_date = null;
	private String name = "noname";
	public static final String heading = String.format("%-10s   %-10s  %-12s   %-15s %10s ", "Date", "Account", "Type", "Name", "Balance" );
	
	
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
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM, d yyyy");
		return String.format("%-10s :%-10s :%-12s :%-15s %10s ", creation_date.format(formatter), accountid, accountType, "\""+name+"\"", "$" + df.format(balance) );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
