package com.revature.dao;

import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionDao 
{
	List<Transaction> getTransactions();
	Transaction getTransactionById(int id);
	void createTransaction(Transaction type);
}
