package com.revature.beans;

public class CryptoType {

	private int typeID;
	private String walletName;
	private String symbol;
	
	public CryptoType(int typeID, String walletName, String symbol) {
		super();
		this.typeID = typeID;
		this.walletName = walletName;
		this.symbol = symbol;
	}
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
