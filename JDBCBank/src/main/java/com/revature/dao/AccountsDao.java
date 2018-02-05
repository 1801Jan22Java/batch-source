package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Accounts;
import com.revature.main.NotEnoughFundsException;

public interface AccountsDao {

	public Accounts getAccountByID(int ID);
	public ArrayList<Accounts> getAllUserAccounts(int ID);
	public ArrayList<Integer> getAllBankIDsPerUser(int ID);
	public int createAccount(int type, float currAmnt);
	public Accounts addFunds(Accounts acc, float amnt);
	public Accounts removeFunds(Accounts acc, float amnt) throws NotEnoughFundsException;
}
