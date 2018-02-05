package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {
	
	private static String filename = "connection.properties";

	//This will return a user object based off of a user id
	public Users getUserByID(int userID) {
		PreparedStatement pstmt = null;
		Users users = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int uID = rs.getInt("USER_ID");
				String userAcc = rs.getString("USER_ACCNAME");
				String userFName = rs.getString("USER_FNAME");
				String userLName = rs.getString("USER_LNAME");
				String userPassword = rs.getString("USER_PASSWORD");
				int userType = rs.getInt("USER_TYPE");
				users = new Users(userID, userAcc, userFName, userLName, userPassword, userType);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return users;
	}

	//This will return a user object based off of a user account
	public Users getUserByAccount(String uA) {
		PreparedStatement pstmt = null;
		Users users = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM USERS WHERE USER_ACCNAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uA);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userID = rs.getInt("USER_ID");
				String userAcc = rs.getString("USER_ACCNAME");
				String userFName = rs.getString("USER_FNAME");
				String userLName = rs.getString("USER_LNAME");
				String userPassword = rs.getString("USER_PASSWORD");
				int userType = rs.getInt("USER_TYPE");
				users = new Users(userID, userAcc, userFName, userLName, userPassword, userType);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		
		return users;
	}

	//This will get the next sequence id number for a user
	public int getNextBankNum() {
		PreparedStatement pstmt = null;
		String uN = "USER_NUM_SEQ.NEXTVAL";
		int nextSeq = 0;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT ? FROM DUAL;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uN);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				nextSeq = rs.getInt("NEXTVAL");
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return nextSeq;
	}

	//This will create a user in the database given parameters
	public int createUser(String userAccount, String userFName, String userLName, String userPassword, int userType) {
		int createAUser = 0;
		//System.out.println(userAccount + " " + userFName + " " + userLName + " " + userPassword + " " + userType);
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO USERS (USER_ID, USER_ACCNAME, USER_FNAME, USER_LNAME, USER_PASSWORD, USER_TYPE)"+
			" VALUES(USER_NUM_SEQ.NEXTVAL,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userAccount);
			pstmt.setString(2,  userFName);
			pstmt.setString(3,  userLName);
			pstmt.setString(4,  userPassword);
			pstmt.setInt(5,  userType);
			createAUser = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return createAUser;
	}

	//This will find the account associated with a given password
	public String checkPassword(String userPassword) {
		Connection con = null;
		String userAccount = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT USER_ACCNAME FROM USERS WHERE USER_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userPassword);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userAccount = rs.getString("USER_ACCNAME");
				return userAccount;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	//This will find and return every user from the database
	@Override
	public ArrayList<Users> getAllUsers() {
		Connection con = null;
		ArrayList<Users> allUsers = new ArrayList<Users>();
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM USERS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userID = rs.getInt("USER_ID");
				String userAccount = rs.getString("USER_ACCNAME");
				String userFName = rs.getString("USER_FNAME");
				String userLName = rs.getString("USER_LNAME");
				String userPassword = rs.getString("USER_PASSWORD");
				int userType = rs.getInt("USER_TYPE");
				allUsers.add(new Users(userID, userAccount, userFName, userLName, userPassword, userType));
			}
			return allUsers;
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	//This will "delete" all users essentially setting their password to "DEL"
	@Override
	public void delAllUsers() {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "{call DEL_ALL_USERS}";
			cs = con.prepareCall(sql);		
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//This allows manipulation of a certain column for a given user
	@Override
	public Users modifyUserField(String field, String newVal, Users editUser) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE USERS SET " + field + " = ?" + " WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newVal);
			pstmt.setInt(2, editUser.getUserID());
			pstmt.executeUpdate();
			return editUser;
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return editUser;
	}

	@Override
	public void delSingleUser() {
		// TODO Auto-generated method stub
		
	}

}


