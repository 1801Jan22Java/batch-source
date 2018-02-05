package com.revature.beans;

public class Bankuser {
	
	private int bankuserID;
	private String bankuser;
	private String password;
	
	public Bankuser() {
		super();

	}
	
	public Bankuser(String bankuser, String password) {
		super();
		this.bankuser = bankuser;
		this.password = password;
	}
	
	public Bankuser(int bankuserID, String bankuser, String password) {
		super();
		this.bankuserID = bankuserID;
		this.bankuser = bankuser;
		this.password = password;
	}

	public int getBankuserID() {
		return bankuserID;
	}

	public void setBankuserID(int bankuserID) {
		this.bankuserID = bankuserID;
	}

	public String getBankuser() {
		return bankuser;
	}

	public void setBankuser(String bankuser) {
		this.bankuser = bankuser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Bankuser [bankuserID=" + bankuserID + ", bankuser=" + bankuser + ", password=" + password + "]";
	}

}
