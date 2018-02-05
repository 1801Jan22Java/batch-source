package com.revature.dao;

import com.revature.beans.User;

public interface UserDao {
	public void registerUser(User user) throws Exception;
	public void login(User user) throws Exception;
	public void viewAccounts (User user) throws Exception;
	public void newAccount (User user, double balance) throws Exception;
	public void deleteAccount (User user, int accountID) throws Exception;
	public void depositAccount(User user, int accountID, double balance) throws Exception;
	public void withdrawAccount(User user, int accountID, double balance) throws Exception;
	public void logout (User user) throws Exception;
}
