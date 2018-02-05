package com.revature.beans;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	public Transaction() {
		super();
	}
	public Transaction(int transactionid, String transactionType, double amount, LocalDate eventDate, String username,
			int accountid, double balance) {
		super();
		this.transactionid = transactionid;
		this.transactionType = transactionType;
		this.amount = amount;
		this.eventDate = eventDate;
		this.username = username;
		this.accountid = accountid;
		this.balance = balance;
	}
	private int transactionid;
	private String transactionType;
	private double amount;
	private LocalDate eventDate;
	private String username;
	private int accountid;
	private double balance;
	public static final String heading = String.format("TRANSACTIONS\n%-12s %-8s %-10s %-12s %10s", "User Name", "Type", "Amount", "Date", "Balance");
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public String getUserid() {
		return username;
	}
	public void setUserid(String username) {
		this.username = username;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM, d yyyy");
		return String.format("%-12s %-8s %10s %-12s %10s", "\""+username+"\"", transactionType, "$"+df.format(amount), eventDate.format(formatter), "$"+df.format(balance) );
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
