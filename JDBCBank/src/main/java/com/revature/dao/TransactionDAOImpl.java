package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.TransactionType;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO{
	
	private static String filename = "connection.properties";

	public List<Transaction> viewAllTransactions(User user, int accountID) {
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM TRANSACTIONS WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?");
			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, accountID);
			ResultSet results = pstmt.executeQuery();
			System.out.println("Viewing all transaction from this account");
			while(results.next()) {
				double money = results.getDouble("AMOUNT");
				TransactionType transactionType = new TransactionType();
				transactionType.setType(results.getString("TRANSACTION_TYPE"));
				BankAccountDAO thisBank = new BankAccountDAOImpl();
				allTransactions.add(new Transaction(user, thisBank.viewBankAccountByID(accountID, user), transactionType, money));
			}
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allTransactions;
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
