package com.revature.dao;

import java.util.List;

import com.revature.beans.Transaction;
import com.revature.beans.TransactionType;

public interface TransactionTypeDAO {
	
	public List<Transaction> getTransactionType();
	public TransactionType getTransactionTypeById(int id);

}
