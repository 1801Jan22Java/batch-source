package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.TransactionType;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO{
	
	private static String filename = "connection.properties";

	public List<Transaction> viewAllTransactions(User user, BankAccount b) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTransaction(User user, BankAccount b, TransactionType transactionType, double amount) {
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TRANSACTIONS(TRANSACTION_TYPE, AMOUNT, USER_ID, BANK_ACCOUNT_ID) VALUES (?,?,?,?)");
			pstmt.setString(1, transactionType.getType());
			pstmt.setDouble(2, amount);
			pstmt.setInt(3, user.getId());
			pstmt.setInt(4, b.getId());
			System.out.println("Adding Transaction table");
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
