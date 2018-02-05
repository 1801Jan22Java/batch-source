package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.exceptions.UserTakenException;
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

	public void createNewUser(User u) throws UserTakenException {
		Connection conn;
		try {
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt = conn.prepareStatement("SELECT USERNAME FROM USERS WHERE USERNAME = ?");
			pstmt.setString(1, u.getUsername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				throw new UserTakenException("Username has been taken");
			} else {
				pstmt = conn.prepareStatement("INSERT INTO USERS(USER_ID, USERNAME, PASSWORD) VALUES (USER_ID_SEQ.NEXTVAL, ?, ?)");
				pstmt.setString(1, u.getUsername());
				pstmt.setString(2, u.getPassword());
				pstmt.executeUpdate();
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserById(int id, String column, String value) {
		Connection conn;
		try {
			conn = ConnectionUtil.getConnectionFromFile(filename);
			PreparedStatement pstmt;
			if(column == "USERNAME") {
				pstmt = conn.prepareStatement("UPDATE USERS SET USERNAME = ? WHERE USER_ID = ?");
			} else {
				pstmt = conn.prepareStatement("UPDATE USERS SET PASSWORD = ? WHERE USER_ID = ?");
			}
			pstmt.setString(1,  value);
			pstmt.setInt(2,  id);
			pstmt.executeUpdate();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAllUsers() {
		Connection conn;
		try{
			conn = ConnectionUtil.getConnectionFromFile(filename);
			CallableStatement cstmt = conn.prepareCall("{call TRUNCATEALLTABLES}");
			cstmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	// Doesn't get used because Super User credential checking is more unique.
	public boolean checkCredentials(String username, String password) {
		return false;
	}

}


