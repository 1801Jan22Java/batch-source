package com.revature.beans;

import java.time.LocalDate;

public class Transaction {

	public Transaction(LocalDate transactionTime, Double amount) {
		super();
		this.transactionTime = transactionTime;
		this.amount = amount;
	}

	public Transaction(LocalDate transactionTime, int transactionID, Double amount) {
		super();
		this.transactionTime = transactionTime;
		this.transactionID = transactionID;
		this.amount = amount;
	}

	private LocalDate transactionTime;
	private int transactionID;
	private Double amount;

	public LocalDate getTransactionTime() {
		return transactionTime;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction amount =" + amount + " , transaction Time = " + transactionTime.getChronology().toString();
	}
}
