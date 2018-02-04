package com.revature.beans;

public class Transaction {
	
	public Transaction() {
		super();
	}
	public Transaction( User user, BankAccount bankAccount, TransactionType transactionType, double amountTransfered) {
		super();
		this.user = user;
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.amountTransfered = amountTransfered;
	}
	
	private User user;
	private BankAccount bankAccount;
	private TransactionType transactionType;
	private double amountTransfered;
	
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
	public double getAmountTransfered() {
		return amountTransfered;
	}
	public void setAmountTransfered(int amountTransfered) {
		this.amountTransfered = amountTransfered;
	}
	@Override
	public String toString() {
		return "Transaction [user=" + user.getUsername() + ", bankAccount=" + bankAccount.getId() + ", transactionType="
				+ transactionType.getType() + ", amountTransfered=" + amountTransfered + "]";
	}
	
	
	
}
