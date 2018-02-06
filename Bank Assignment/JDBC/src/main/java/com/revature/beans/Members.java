package com.revature.beans;

public class Members {
	

	private int memberID;
	private String username;
	private String password;
	
	public Members(int memberID, String username, String password) {
		super();
		this.memberID = memberID;
		this.username = username;
		this.password = password;
	}
	
	public int getMemberId() {
		return memberID;
	}

	public void setMemberId(int id) {
		this.memberID = memberID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
