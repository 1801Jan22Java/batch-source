package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class UserAccountsDaoImpl implements UserAccountsDao{

	private static String filename = "connection.properties";

	//This will create a user_accounts entry based on a user and an account associated with the user
	@Override
	public void createUserAccount(int userID, int accID) {
		int createuAcc = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO USER_ACCOUNTS (USER_ID, BANK_ACCOUNT_ID)"+
			" VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  userID);
			pstmt.setInt(2,  accID);			
			createuAcc = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	

	//This will return the max ID for an account 
	//NOT ACTUALLY USED
	@Override
	public int maxAccountID(int ID) {
		int accMax = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT MAX(BANK_ACCOUNT_ID) AS MAX_BANK FROM USER_ACCOUNTS WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				accMax = rs.getInt("MAX_BANK");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		return accMax;

	}


	//This will remove an account from the user_accounts with a given user id and account number
	@Override
	public void removeAccount(int userID, int accID) {
		int createuAcc = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM USER_ACCOUNTS WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  userID);
			pstmt.setInt(2,  accID);			
			createuAcc = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	
	
}

