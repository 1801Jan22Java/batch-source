package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;


import com.revature.beans.User;
import com.revature.main.SQLProfileUpdateException;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	private static String filename = "connection.properties";
 
	@Override
	public User addUser(String username, String password, String firstname, String lastname) {
		PreparedStatement pstmt = null;
		User newUser = null;
		int usersCreated = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO users (username, password, firstname, lastname) VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, firstname);
			pstmt.setString(4, lastname);
			// Save number returned from insert statement
			usersCreated = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// If nothing was returned by the insert statement, then it didn't work
		if (usersCreated == 0) {
			return null;
		} else {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile(filename);
				String sql = "SELECT u.userid, c.keyword FROM users u INNER JOIN common_lookup c ON u.user_type = c.common_lookup_id WHERE u.username = ? AND c.ref_table = 'users' AND c.ref_column = 'user_type'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				// Save number returned from insert statement
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					int userid = rs.getInt("userid");
					String userType = rs.getString("keyword");
					newUser = new User(userid, username, userType, firstname, lastname);
				}
				con.close();
			} catch (SQLException e) {
				return null;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return newUser;
		}
	}

	@Override
	public boolean isAvailable(String username) {
		PreparedStatement pstmt = null;
		boolean isUnique = true;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT username FROM users WHERE username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the username is taken, so set isUnique to false
			// IF rs.next() returns false, then the username is available, so set isUnique to true
			isUnique = !rs.next();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isUnique;
	}
  
	@Override
	public User login(String username, String password) {
		PreparedStatement pstmt = null;
		boolean success = false;
		int userid = 0;
		String type = null;
		String firstname = null;
		String lastname = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT u.userid, c.keyword, u.firstname, u.lastname FROM users u INNER JOIN common_lookup c ON u.user_type = c.common_lookup_id WHERE u.username = ? AND u.password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the password matches the username, so save all info to object
			if(rs.next()){
				userid = rs.getInt("userid");
				type = rs.getString("keyword");
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				
				success = true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (success) {
			return new User(userid, username, type, firstname, lastname);
		} else {
			return null;
		}
	}

	@Override
	public boolean getAllUsers(User thisUser) {
		thisUser.getUsers().clear();
		PreparedStatement pstmt = null;
		boolean success = false;
		int userid = 0;
		String type = null;
		String firstname = null;
		String lastname = null;
		String username = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT u.userid, u.username, c.keyword, u.firstname, u.lastname FROM users u INNER JOIN common_lookup c ON u.user_type = c.common_lookup_id WHERE u.password IS NOT NULL AND u.username != 'admin'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the password matches the username, so save all info to object
			while(rs.next()){
				userid = rs.getInt("userid");
				username = rs.getString("username");
				type = rs.getString("keyword");
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				thisUser.getUsers().add(new User(userid, username, type, firstname, lastname));
				success = true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (success) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean disableUser(User thisUser) {
		PreparedStatement pstmt = null;
		int usersDeleted = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE users SET password = NULL WHERE userid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisUser.getUserid());
			// Save number returned from insert statement
			usersDeleted = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// If nothing was returned by the insert statement, then it didn't work
		if (usersDeleted == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProfile(String keyword, String value, User thisUser) throws SQLProfileUpdateException {
		PreparedStatement pstmt = null;
		int usersUpdated = 0;
		try{
			String sql = "";
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			if (keyword.equals("USERNAME") || keyword.equals("PASSWORD") || keyword.equals("FIRSTNAME") || keyword.equals("LASTNAME")) {
				sql = "UPDATE users SET " + keyword + " = ? WHERE userid = ?";
			} else {
				throw new SQLProfileUpdateException("\"Sorry, the " + keyword + " was not changed.\"");
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setInt(2, thisUser.getUserid());
			// Save number returned from insert statement
			usersUpdated = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// If nothing was returned by the insert statement, then it didn't work
		if (usersUpdated == 0) {
			throw new SQLProfileUpdateException("\"Sorry, the " + keyword + " was not changed.\"");
		}
		return true;
	}

}
