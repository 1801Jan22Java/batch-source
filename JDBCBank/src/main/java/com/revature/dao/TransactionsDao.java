package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Transactions;

public interface TransactionsDao {
	
	public void addTransaction(int userId, int accountID, float transAmnt);
	public void withTransaction(int userID, int accountID, float TransAmnt);
	public ArrayList<Transactions> getUserTransactions(int userID);

}
