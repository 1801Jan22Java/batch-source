package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;

public interface TransactionDao {
	public List<Transaction> getAccountTransactions(Account account);
}
