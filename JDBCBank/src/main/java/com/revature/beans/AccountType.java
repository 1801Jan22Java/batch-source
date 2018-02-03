package com.revature.beans;

public class AccountType {
	
	public AccountType() {
		super();
	}
	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", type=" + type + "]";
	}
	
}
