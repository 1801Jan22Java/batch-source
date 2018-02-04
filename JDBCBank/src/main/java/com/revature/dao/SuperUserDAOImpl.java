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

public class SuperUserDAOImpl implements SuperUserDAO {
	
	private static String filename = "connection.properties";

	public List<User> viewAllUsers() {
		List<User> users = new ArrayList<User>();
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USERS");
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int id = results.getInt("USER_ID");
				String username = results.getString("USERNAME");
				String password = results.getString("PASSWORD");
				users.add(new User(id, username, password));
			}
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void createNewUser(User u) {
		Connection conn;
		try {
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USERS(USER_ID, USERNAME, PASSWORD) VALUES (USER_ID_SEQ.NEXTVAL, ?, ?)");
			pstmt.setString(1, "cchan67");
			pstmt.setString(2, "password");
			pstmt.executeUpdate();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
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
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE USERNAME = ?");
			pstmt.setString(1, username);
			ResultSet results = pstmt.executeQuery();
			if(results.next()) {
				int id = results.getInt("USERID");
				newUser.setId(id);
				newUser.setUsername(username);
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newUser;
	}

	public boolean checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}


