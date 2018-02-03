package com.revature.beans;

import java.util.ArrayList;

public class User extends AbstractUser{
	public User(Long uSER_ID, Credentials cred) {
		super();
		USER_ID = uSER_ID;
		this.cred = cred;
		accounts = new ArrayList<Account>();
	}
	private Credentials cred;
	private Long USER_ID;
	private ArrayList<Account> accounts;
	
	
	
	
	
	
	
}
