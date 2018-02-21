package com.revature.beans;

public class Wallet {

	private int walletID;
	private int empID;
	private String walletName;
	private String walletAddress;
	private int walletType;
	
	public Wallet(int walletID, int empID, String walletName, String walletAddress, int walletType) {
		super();
		this.walletID = walletID;
		this.empID = empID;
		this.walletName = walletName;
		this.walletAddress = walletAddress;
		this.walletType = walletType;
	}
	
	public int getWalletID() {
		return walletID;
	}
	public void setWalletID(int walletID) {
		this.walletID = walletID;
	}
	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public String getWalletAddress() {
		return walletAddress;
	}
	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
	public int getWalletType() {
		return walletType;
	}
	public void setWalletType(int walletType) {
		this.walletType = walletType;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
}
