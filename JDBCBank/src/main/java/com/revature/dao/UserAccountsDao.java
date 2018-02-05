package com.revature.dao;

import com.revature.beans.UserAccounts;

public interface UserAccountsDao {

	public void createUserAccount(int userID, int accID);
	//public int accountsForUser(int ID);
	public int maxAccountID(int ID);
	public void removeAccount(int userID, int accID);
}
