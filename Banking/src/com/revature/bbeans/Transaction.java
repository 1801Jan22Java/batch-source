package com.revature.bbeans;

import java.sql.Date;

public class Transaction {
	public enum TransactionType { Transfer, Withdrawal, Deposit };
	
	private int transactionID;
	private int amount;
	private int accountID;
	private Date transactionDate;
	private TransactionType transactionType;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int transactionID, int amount, int accountID, Date transactionDate, TransactionType transactionType) {
		this.transactionID   = transactionID;
		this.amount          = amount;
		this.accountID       = accountID;
		this.transactionType = transactionType;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public int getAmount() {
		return amount;
	}

	public int getAccountID() {
		return accountID;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

}
