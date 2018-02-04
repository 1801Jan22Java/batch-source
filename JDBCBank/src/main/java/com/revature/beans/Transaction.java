package com.revature.beans;

public class Transaction {
	
	private int transactionID;
	private int balanceID;
	private int accountID;
	private int type;
	private int transactionAmount;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int balanceID, int accountID, int type, int transactionAmount) {
		super();
		this.balanceID = balanceID;
		this.type = type;
		this.transactionAmount = transactionAmount;
	}

	public Transaction(int transactionID, int balanceID, int accountID, int type, int transactionAmount) {
		super();
		this.transactionID = transactionID;
		this.balanceID = balanceID;
		this.accountID = accountID;
		this.type = type;
		this.transactionAmount = transactionAmount;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getBalanceID() {
		return balanceID;
	}

	public void setBalanceID(int balanceID) {
		this.balanceID = balanceID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", balanceID=" + balanceID + ", accountID=" + accountID
				+ ", type=" + type + ", transactionAmount=" + transactionAmount + "]";
	}

}
