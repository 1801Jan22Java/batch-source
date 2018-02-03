package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;


public class UserDAOImpl implements UserDAO {
	
	public boolean checkCredentials(String username, String password) {
		boolean userExists = false;
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("SELECT ID FROM USER WHERE USERNAME = ? AND PASSWORD = ?");
//			pstmt.setString(1, username);
//			pstmt.setString(1, password);
//			ResultSet results = pstmt.executeQuery();
//			if(results.next()) {
//				userExists = true;
//			}
//			conn.close();
//		}
		
		return userExists;
	}

	public User getUserById(int id) {
		User newUser = new User();
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERID = ?");
//			pstmt.setInt(1, id);
//			ResultSet results = pstmt.executeQuery();
//			if(results.next()) {
//				String username = results.getString("USERNAME");
//				newUser.setId = id;
//				newUser.setUsername = username;
//			}
//			conn.close();
//		}
		return newUser;
	}

	public User getUserByUsername(String username) {
		User newUser = new User();
//		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
//			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
//			pstmt.setInt(1, id);
//			ResultSet results = pstmt.executeQuery();
//			if(results.next()) {
//				int id = results.getString("USERID");
//				newUser.setId = id;
//				newUser.setUsername = username;
//			}
//			conn.close();
//		}
		return newUser;
	}
}
