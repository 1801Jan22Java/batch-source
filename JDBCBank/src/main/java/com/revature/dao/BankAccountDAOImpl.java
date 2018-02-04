package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankAccountDAOImpl implements BankAccountDAO{
	
	private static String filename = "connection.properties";

	public void createAccount(String accountType, User user) {
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BANKACCOUNTS (BANK_ACCOUNT_ID, ACCOUNT_TYPE, BALANCE, USER_ID) VALUES (BANK_ACCOUNT_ID_SEQ.NEXTVAL, ?, ?, ?)");
			pstmt.setString(1, accountType);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, user.getId());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(BankAccount b) {
		// TODO Auto-generated method stub
		
	}

	public List<BankAccount> viewBankAccounts(User user) {
		List<BankAccount> userAccounts = new ArrayList<BankAccount>();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT BANK_ACCOUNT_ID, BALANCE, ACCOUNT_TYPE FROM BANKACCOUNTS WHERE BANKACCOUNTS.USER_ID = ?");
			pstmt.setInt(1, user.getId());
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int id = results.getInt("BANK_ACCOUNT_ID");
				double balance = results.getDouble("BALANCE");
				String accountType = results.getString("ACCOUNT_TYPE");
				userAccounts.add(new BankAccount(id, balance, user, accountType));
			}
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAccounts;
	}

}
