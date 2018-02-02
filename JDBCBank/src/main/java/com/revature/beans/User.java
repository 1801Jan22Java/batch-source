package com.revature.beans;

import java.util.*;

public class User {

	public User() {
		
	}
	
	public User(String firstName, String lastName, String userName, String password) {
		
	}
	
	public User(String userName, String password) {
		
	}
	
	public boolean signIn() {
		return true;
	}
	
	public List<Account> getAllAccounts(){
		return new ArrayList<Account>();
	}
}
