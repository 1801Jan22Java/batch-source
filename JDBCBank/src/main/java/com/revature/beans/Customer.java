package com.revature.beans;

public class Customer {

	private String username;
	private String password;
	private int userId;
	private Account accountId;
	private int isSuper; // default false
	private int loginState; // default false

	public Customer() {
		super();
	}
	
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Customer(String username, String password, int userId, Account account, int isSuper,
			int loginState) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.accountId = account;
		this.isSuper = isSuper;
		this.loginState = loginState;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return accountId;
	}

	public void setAccount(Account account) {
		this.accountId = account;
	}

	public int isSuper() {
		return isSuper;
	}

	public void setSuper(int isSuper) {
		this.isSuper = isSuper;
	}

	public int isLoginState() {
		return loginState;
	}

	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", userId=" + userId + ", account="
				+ accountId + ", isSuper=" + isSuper + ", loginState=" + loginState + "]";
	}

}
