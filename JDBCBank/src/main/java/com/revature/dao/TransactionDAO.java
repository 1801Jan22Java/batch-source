package com.revature.dao;

import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;

public interface TransactionDAO {
	
	public List<Transaction> viewAllTransactions(User user, BankAccount b);
	
}
