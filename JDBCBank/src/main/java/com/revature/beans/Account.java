package com.revature.beans;

public class Account {
	private String name;
	private int balance;
	private int id;
	
	public Account() {
		
	}
	
	public Account(String name) {
		this.name = name;
		this.balance = 0;
	}
	
	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public Account(int id, String name, int balance) {
		this.id =  id;
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return id + " " + name + " " + balance;
	}
	
}
