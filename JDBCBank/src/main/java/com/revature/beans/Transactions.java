package com.revature.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transactions {

	//Constructors
	public Transactions() {}
	
	public Transactions(int transID, int userID, int bankAccountID, LocalDateTime transTime, float transAmount, int transType) {
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
	private LocalDateTime transTime;
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

	public LocalDateTime getTransTime() {
		return transTime;
	}

	public void setTransTime(LocalDateTime transTime) {
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

	//toString
	@Override
	public String toString() {
		/*return "Transactions [transID=" + transID + ", userID=" + userID + ", bankAccountID=" + bankAccountID
				+ ", transTime=" + transTime + ", transAmount=" + transAmount + ", transType=" + transType + "]";*/
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy K:mm:ss a");
		transTime.format(formatter);
		String userT;
		if (transType == 5)
			userT = "Deposit";
		else
			userT = "Withdraw";
		
		return String.format("Transaction ID: %d         Account ID: %d          User ID: %d          \nTime of Transaction: %s\n Transaction Type: %s          Amount: $ %.2f%n"
				,transID, bankAccountID, userID, transTime.format(formatter), userT, transAmount);
		
		
	}
	
	

}
