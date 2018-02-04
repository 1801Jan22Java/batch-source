package com.revature.beans;

public class Balance {
	
	private int balanceID;
	private double initialBalance;
	
	public Balance() {
		super();
	}
	
	public Balance(double initialBalance) {
		super();
		this.initialBalance = initialBalance;
	}

	public Balance(int balanceID, double initialBalance) {
		super();
		this.balanceID = balanceID;
		this.initialBalance = initialBalance;
	}

	public int getBalanceID() {
		return balanceID;
	}

	public void setBalanceID(int balanceID) {
		this.balanceID = balanceID;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	@Override
	public String toString() {
		return "Balance [balanceID=" + balanceID + ", initialBalance=" + initialBalance
				+ "]";
	}
	
	
}
