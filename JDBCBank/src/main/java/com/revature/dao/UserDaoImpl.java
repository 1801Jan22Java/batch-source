package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.revature.beans.Account;
import com.revature.beans.User;

import cam.revature.exceptions.AccountNotFoundException;
import cam.revature.exceptions.InvalidLoginException;
import cam.revature.exceptions.OverdraftException;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		super();
	}

	public void registerUser(User user) throws Exception {
		// creates a new entry in the Users table for the specified userName and Password
		String sql = "INSERT INTO Users (UserName, Password) VALUES (?,?)";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.executeUpdate();
		System.out.println("User successfully registered.");
	}

	public void login(User user) throws Exception {
		// executes search for userName and password in Users table
		String sql = "SELECT userID FROM Users WHERE UserName = ? AND Password = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		// if successful assigns UserID to User object
		if (rs.next()) {
			user.setUserID(rs.getInt("UserID"));
			System.out.println("User successfully logged in.");
		} else { // if unsuccessful throws InvalidLoginException
			throw new InvalidLoginException();
		}
	}

	public void viewAccounts(User user) throws Exception {
		// retrieves a resultSet with the accounts of the user
		ArrayList<Account> ar = new ArrayList<Account>();
		String sql = "SELECT AccountID, Balance FROM Accounts WHERE UserID = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, user.getUserID());
		ResultSet rs = pstmt.executeQuery();
		// creates an ArrayList of Account objects with the AccountID and Balance
		while (rs.next()) {
			ar.add(new Account(rs.getInt("AccountID"), rs.getDouble("Balance")));
		}
		// sets that ArrayList to the user's Accounts data member and displays
		user.setAccounts(ar);
		System.out.println(user.getAccounts().toString());
	}

	public void newAccount(User user, double balance) throws Exception {
		// creates a new account for the User with the specified initial balance
		String sql = "INSERT INTO Accounts (UserID, Balance) VALUES (?,?)";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, user.getUserID());
		pstmt.setDouble(2, balance);
		pstmt.executeUpdate();
		System.out.println("Account added.");
	}

	public void deleteAccount(User user, int accountID) throws Exception {
		// removes an account from the Accounts table if the user controls that account and it is empty
		String sql = "DELETE FROM Accounts WHERE AccountID = ? AND Balance = 0 AND UserId = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		pstmt.setInt(2, user.getUserID());
		pstmt.executeUpdate();
		// displays updated accounts
		this.viewAccounts(user);
	}

	public void depositAccount(User user, int accountID, double amount) throws Exception {
		// queries the database to find the current balance for the specified account
		double newBalance;
		String sql = "SELECT Balance FROM Accounts WHERE AccountID = ? AND UserId = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		pstmt.setInt(2, user.getUserID());
		ResultSet rs = pstmt.executeQuery();
		// if the account exists and belongs to the user
		if (rs.next()) {
			// add the passed amount to the balance and updates the table
			newBalance = rs.getDouble("Balance");
			newBalance += amount;
			sql = "UPDATE Accounts SET Balance = ? WHERE AccountID = ?";
			pstmt = user.getConn().prepareStatement(sql);
			pstmt.setDouble(1, newBalance);
			pstmt.setInt(2, accountID);
			pstmt.executeUpdate();
			System.out.println("Deposited amount: $" + amount + " to account #" + accountID);
		} else {
			// otherwise, throws an exception indicating that the account was not found
			throw new AccountNotFoundException();
		}
		// displays updated accounts
		this.viewAccounts(user);
	}

	public void withdrawAccount(User user, int accountID, double balance) throws Exception {
		// queries the database to find the current balance for the specified account
		double newBalance;
		String sql = "SELECT Balance FROM Accounts WHERE AccountID = ? AND UserId = ?";
		PreparedStatement pstmt = user.getConn().prepareStatement(sql);
		pstmt.setInt(1, accountID);
		pstmt.setInt(2, user.getUserID());
		ResultSet rs = pstmt.executeQuery();
		// if the account exists and belongs to the user
		if (rs.next()) {
			newBalance = rs.getDouble("Balance");
			// if the user is not attempting to overdraw
			if (newBalance >= balance) {
				// subtracts the passed amount from the balance and updates the table
				newBalance -= balance;
				sql = "UPDATE Accounts SET Balance = ? WHERE AccountID = ?";
				pstmt = user.getConn().prepareStatement(sql);
				pstmt.setDouble(1, newBalance);
				pstmt.setInt(2, accountID);
				pstmt.executeUpdate();
			} else {
				// throws an exception if user tries to withdraw more than what is in the account
				throw new OverdraftException();
			}
		} else {
			// otherwise, throws an exception indicating that the account was not found
			throw new AccountNotFoundException();
		}
		// displays updated accounts
		this.viewAccounts(user);
	}

	public void logout(User user) throws Exception {
		// closes users connection to the database
		Connection conn = user.getConn();
		conn.close();
		user.setConn(null);
	}
}