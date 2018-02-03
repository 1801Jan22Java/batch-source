package com.revature.beans;

import java.sql.Date;

public class Transactions {

	//Constructors
	public Transactions() {}
	
	public Transactions(int transID, int userID, int bankAccountID, Date transTime, float transAmount, int transType) {
		super();
		this.transID = transID;
		this.userID = userID;
		this.bankAccountID = bankAccountID;
		this.transTime = transTime;
		this.transAmount = transAmount;
		this.transType = transType;
	}
	
	//Variables
	private int transID;
	private int userID;
	private int bankAccountID;
	private Date transTime;
	private float transAmount;
	private int transType;
	
	//Getters and Setters
	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public Date getTransTime() {
		return transTime;
	}

	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	public float getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(float transAmount) {
		this.transAmount = transAmount;
	}

	public int getTransType() {
		return transType;
	}

	public void setTransType(int transType) {
		this.transType = transType;
	}
	
	

}
