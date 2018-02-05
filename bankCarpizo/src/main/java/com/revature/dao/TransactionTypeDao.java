package com.revature.dao;

import java.util.List;

import com.revature.beans.TransactionType;

public interface TransactionTypeDao {
	List<TransactionType> getAllTransactionTypes();
	TransactionType getTransactionTypeById(int id);
}
