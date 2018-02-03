package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankAccountDAOImpl implements BankAccountDAO{
	
	private static String filename = "connection.properties";

	public void createAccount(String accountType, User user) {
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BANK ACCOUNT "
//					+ "(BANKACCOUNT_ID, BALANCE, ACCOUNT_TYPE, USERID)"
//					+ "VALUES (ID SEQ, ?, ?, ?)");
//			pstmt.setInt(1, 0);
//			pstmt.setString(2, accountType);
//			pstmt.setInt(3, user.getId());
//			pstmt.executeUpdate();
//			conn.close();
//		}

		
	}

	public void deleteAccount(BankAccount b) {
		// TODO Auto-generated method stub
		
	}

	public List<BankAccount> viewBankAccounts(User user) {
		List<BankAccount> userAccounts = new ArrayList<BankAccount>();

//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			 //I NEED TO CONNECT JDBC TO MAVEN PROJECT
//			PreparedStatement pstmt = conn.prepareStatement("SELECT BANKACCOUNT_ID, BALANCE, ACCOUNT_TYPE FROM BANKACCOUNT WHERE BANKACCOUNT.USERID = ?");
//			pstmt.setInt(1, user.getId());
//			ResultsSet results = pstmt.executeQuery();
//			while(results.next()) {
//				int id = results.getInt("BANKACCOUNT_ID");
//				double balance = results.getDouble("BALANCE");
//				String accountType = results.getString("ACCOUNT_TYPE");
//				userAccounts.add(new BankAccount(id, balance, user, accountType));
//			}
//			conn.close();
//		}
		return null;
	}

}
