package com.revature.dao;

import java.util.*;
import com.revature.beans.Transaction;


public interface TransactionDao {
	public String filename = "connection.properties";
	public List<Transaction> getTransactions();
	public Transaction getTransactionByID(int id);
	public int addTransaction(int balancdId, int accountId, int type, double transactionAmount);

}
