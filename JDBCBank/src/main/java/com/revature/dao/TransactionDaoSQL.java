package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoSQL implements TransactionDao {

	@Override
	public List<Transaction> getTransactions() {
		List<Transaction> resultTransaction = new ArrayList<Transaction>();
		
		return resultTransaction;
	}

	@Override
	public Transaction getTransactionByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTransaction(int balancdId, int accountId, int type, double transactionAmount) {
		// TODO Auto-generated method stub
		
	}

}
