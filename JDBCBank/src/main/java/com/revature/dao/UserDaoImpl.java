package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.revature.beans.Account;
import com.revature.beans.User;
import cam.revature.exceptions.InvalidLoginException;
import cam.revature.exceptions.OverdraftException;

public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl() {
		super();
	}
	
	public void registerUser(User user) throws Exception {
		String sql = "INSERT INTO Users (UserName, Password) VALUES (?,?)";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.executeUpdate();
		System.out.println("User successfully registered.");
	}

	public void login (User user) throws Exception {
		// executes search for userName and password in Users table
		String sql = "SELECT userID FROM Users WHERE UserName = ? AND Password = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		// if successful assigns UserID to User object and returns true
		if (rs.next()) {
			user.setUserID(rs.getInt("UserID"));
			System.out.println("User successfully logged in.");
		} else { throw new InvalidLoginException();
		}
	}
	
	public void viewAccounts(User user) throws Exception {
		// retrieves a resultSet with the accounts of specified user and returns as ArrayList
		ArrayList<Account> ar = new ArrayList<Account>();
		String sql = "SELECT AccountID, Balance FROM Accounts WHERE UserID = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, user.getUserID());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ar.add(new Account(rs.getInt("AccountID"),rs.getDouble("Balance")));
		}
		user.setAccounts(ar);
		System.out.println(user.getAccounts().toString());
	}

	public void newAccount(User user, double balance) throws Exception {
		String sql = "INSERT INTO Accounts (UserID, Balance) VALUES (?,?)";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, user.getUserID());
		pstmt.setDouble(2, balance);
		pstmt.executeUpdate();
		System.out.println("Account added.");
	}

	public void deleteAccount(User user, int accountID) throws Exception {
		String sql = "DELETE FROM Accounts WHERE AccountID = ? AND Balance = 0";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		pstmt.executeUpdate();
		this.viewAccounts(user);
	}
	
	public void depositAccount(User user, int accountID, double amount) throws Exception{
		double newBalance;
		String sql = "SELECT Balance FROM Accounts WHERE AccountID = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			newBalance = rs.getDouble("Balance");
			newBalance += amount;
			sql = "UPDATE Accounts SET Balance = ? WHERE AccountID = ?";
			pstmt = user.getConn().prepareStatement(sql);
			pstmt.setDouble(1, newBalance);
			pstmt.setInt(2, accountID);
			pstmt.executeUpdate();
		}
		this.viewAccounts(user);
	}
	
	public void withdrawAccount(User user, int accountID, double balance) throws Exception{
		double newBalance;
		String sql = "SELECT Balance FROM Accounts WHERE AccountID = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			newBalance = rs.getDouble("Balance");
			if (newBalance >= balance) {
				newBalance -= balance;
				sql = "UPDATE Accounts SET Balance = ? WHERE AccountID = ?";
				pstmt = user.getConn().prepareStatement(sql);
				pstmt.setDouble(1, newBalance);
				pstmt.setInt(2, accountID);
				pstmt.executeUpdate();
			} else { throw new OverdraftException();
			}
		}
		this.viewAccounts(user);
	}
	
	public void logout (User user) throws Exception {
		Connection conn = user.getConn();
		conn.close();
		user.setConn(null);
	}
}