package com.revature.beans;

public class Transaction {
	
	public Transaction() {
		super();
	}
	public Transaction(int id, User user, BankAccount bankAccount, TransactionType transactionType, int amountTransfered) {
		super();
		this.id = id;
		this.user = user;
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.amountTransfered = amountTransfered;
	}
	
	private int id;
	private User user;
	private BankAccount bankAccount;
	private TransactionType transactionType;
	private int amountTransfered;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public int getAmountTransfered() {
		return amountTransfered;
	}
	public void setAmountTransfered(int amountTransfered) {
		this.amountTransfered = amountTransfered;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", user=" + user + ", bankAccount=" + bankAccount + ", transactionType="
				+ transactionType + ", amountTransfered=" + amountTransfered + "]";
	}
	
	
	
}
