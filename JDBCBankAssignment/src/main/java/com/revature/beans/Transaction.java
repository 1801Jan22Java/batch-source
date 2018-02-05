package com.revature.beans;

import java.sql.Timestamp;

public class Transaction {

	private int transactionID;
	private int userID;
	private int accountID;
	private float oldBal;
	private float newBal;
	private Timestamp timestamp;
	
	public Transaction(int transactionID, int userID, int accountID, float oldBal, float newBal, Timestamp timestamp) {
		super();
		this.transactionID = transactionID;
		this.userID = userID;
		this.accountID = accountID;
		this.oldBal = oldBal;
		this.newBal = newBal;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		
		return "Transaction ID: " + transactionID + " Account ID: " + accountID + " Start balance: " + oldBal + " End balance: " + newBal + " Time: " + timestamp;
	}
	
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public float getOldBal() {
		return oldBal;
	}
	public void setOldBal(float oldBal) {
		this.oldBal = oldBal;
	}
	public float getNewBal() {
		return newBal;
	}
	public void setNewBal(float newBal) {
		this.newBal = newBal;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
