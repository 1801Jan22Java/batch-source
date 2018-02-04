package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;


public class UserDAOImpl implements UserDAO {
	
	private static String filename = "connection.properties";
	
	public boolean checkCredentials(String username, String password) {
		boolean userExists = false;
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet results = pstmt.executeQuery();
			if(results.next()) {
				userExists = true;
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userExists;
	}

	public User getUserById(int id) {
		User newUser = new User();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");
			pstmt.setInt(1, id);
			ResultSet results = pstmt.executeQuery();
			if(results.next()) {
				String username = results.getString("USERNAME");
				newUser.setId(id);
				newUser.setUsername(username);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newUser;
	}

	public User getUserByUsername(String username) {
		User newUser = new User();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
			pstmt.setString(1, username);
			ResultSet results = pstmt.executeQuery();
			if(results.next()) {
				int id = results.getInt("USER_ID");
				newUser.setId(id);
				newUser.setUsername(username);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newUser;
	}
}
