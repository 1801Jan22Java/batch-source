package com.revature.dao;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {
	public void createAccount(User u);
	public void viewAccount(User u);
	public void deleteAccount(int accID);
	
	public double withdraw(int accID);
	public double deposit(int accID);
	
}
