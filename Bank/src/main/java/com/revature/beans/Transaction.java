package com.revature.beans;

import java.time.LocalDate;

public class Transaction {
	public Transaction() {
		super();
	}
	public Transaction(int transactionid, int transactionType, double amount, LocalDate eventDate, int userid,
			int accountid) {
		super();
		this.transactionid = transactionid;
		this.transactionType = transactionType;
		this.amount = amount;
		this.eventDate = eventDate;
		this.userid = userid;
		this.accountid = accountid;
	}
	private int transactionid;
	private int transactionType;
	private double amount;
	private LocalDate eventDate;
	private int userid;
	private int accountid;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactionType=" + transactionType + ", amount="
				+ amount + ", eventDate=" + eventDate + ", userid=" + userid + ", accountid=" + accountid + "]";
	}
}
