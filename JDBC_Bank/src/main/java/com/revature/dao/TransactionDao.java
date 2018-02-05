package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;

public interface TransactionDao {
	public List<Transaction> getTransactions(Account a);
	public Transaction getTransactionByID(int id);
	public void addTransaction(Transaction t, Account a);
	public void deleteTransaction(Transaction t);
}
