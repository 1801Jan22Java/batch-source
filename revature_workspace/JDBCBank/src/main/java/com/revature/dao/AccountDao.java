package com.revature.dao;

import java.util.List;

import com.revature.Exceptions.OverdraftException;
import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {
	public Account getAccountById();
	public void addAccount(Account account, User user);
	public void deposit(int accountID,float amount,User user);
	public void withdrawal(User user,int accountID,float amount) throws OverdraftException;
	public void selectAction(int option, User user);
	public void showBalance(User user, int accountID);
	public void closeAccount(User user, int accountID);

}
