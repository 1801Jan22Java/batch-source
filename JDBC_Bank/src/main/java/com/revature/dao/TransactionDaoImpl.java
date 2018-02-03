package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	public static final String filename = "connection.properties";
	
	public ArrayList<Transaction> getTransactions(Account a) {
		ArrayList<Transaction> monies = null;
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int account = a.getAccountID();
			int valid = 0;
			int id = 0;
			Double amount = 0.0;
			Date when = null;
			String sql = "SELECT * FROM TRANSACTIONS WHERE ACCOUNTID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				valid = rs.getInt(5);
				if(valid > 0) {
					// within the database, a value of 0 will mark a 'dead' transaction, one 
					// whose account was deleted. The actual data is not removed
					// for archival purposes
					id = rs.getInt(1);
					amount = rs.getDouble(3);
					when = rs.getDate(4);
				}
			}
			
			con.close();
		} catch (SQLException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return monies;
	}

	public Transaction getTransactionByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction addTransaction() {
		
		return null;
	}

	public void deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub

	}

}
