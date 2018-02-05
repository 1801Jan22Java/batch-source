package com.revature.beans;

public class Account {
	

	
	private int accID;
	private int bankuserID;
	private int type;
	private int balanceID;
	
	public Account() {
		super();
	}
	
	public Account(int bankuserID, int type, int balanceID) {
		super();
		this.bankuserID = bankuserID;
		this.type = type;
		this.balanceID = balanceID;
	}
	
	public Account(int accID, int bankuserID, int type, int balanceID) {
		super();
		this.accID = accID;
		this.bankuserID = bankuserID;
		this.type = type;
		this.balanceID = balanceID;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public int getBankuserID() {
		return bankuserID;
	}

	public void setBankuserID(int bankuserID) {
		this.bankuserID = bankuserID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBalanceID() {
		return balanceID;
	}

	public void setBalanceID(int balanceID) {
		this.balanceID = balanceID;
	}

	@Override
	public String toString() {
		return "Account [accID=" + accID + ", bankuserID=" + bankuserID + ", type=" + type + ", balance=" + balanceID
				+ "]";
	}

	
}
