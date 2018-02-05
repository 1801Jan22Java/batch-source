package com.revature.vo;

public class BankAccountVo {

	public int id;			// bank account it
	public int user_id;		// shows whose bank account is
	public int balance;		// balance of 
	
	public BankAccountVo(int id, int user_id, int balance) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccountVo [id=" + id + ", user_id=" + user_id + ", balance=" + balance + "]";
	}
}
