package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Transaction;

public interface TransactionDao {
	public ArrayList<Transaction> getTransactions(int accountid);
}
