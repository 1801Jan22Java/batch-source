package com.revature.beans;

import java.sql.Date;

public class Transaction {

	public Transaction(Date transactionTime, int transactionID, Double amount) {
		super();
		this.transactionTime = transactionTime;
		this.transactionID = transactionID;
		this.amount = amount;
	}

	private Date transactionTime;
	private int transactionID;
	private Double amount;

	public Date getTransactionTime() {
		return transactionTime;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public Double getAmount() {
		return amount;
	}
}
