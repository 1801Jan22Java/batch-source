package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.AccountNotEmptyException;
import com.revature.util.InvalidAccountIdException;

public interface AccountDao {

	public ArrayList<Account> getAccounts(User u) throws InvalidAccountIdException;
	public Account getAccountByID(int id);
	public void addAccount(Account a, User u);
	public int getNextAccountID();
	public void deleteAccount(Account a) throws AccountNotEmptyException;
	
}
