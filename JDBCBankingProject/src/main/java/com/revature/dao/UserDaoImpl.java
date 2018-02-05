package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.IllegalPasswordException;
import com.revature.util.IllegalUsernameException;
import com.revature.util.IncorrectCredentialsException;

public class UserDaoImpl implements UserDao {
	
	private static String filename = "connection.properties";

	@Override
	public User createUser(User user) throws IllegalUsernameException, IllegalPasswordException {
		for (User u : this.superGetUsers()) {
			if (u.getUsername().equals(user.getUsername())) {
				throw new IllegalUsernameException();
			}
		}
		if (user.getPassword().length() < 8) {
			throw new IllegalPasswordException();
		}
		
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL CREATE_USER(?, ?, ?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, user.getUsername());
			cstmt.setString(2, user.getPassword());
			cstmt.setString(3, user.getFirstName());
			cstmt.setString(4, user.getLastName());
			cstmt.executeUpdate();
			
			String getIdSql = "SELECT USER_ID FROM BANK_USER WHERE USERNAME=?";
			pstmt = con.prepareStatement(getIdSql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user.setuserId(rs.getInt("USER_ID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public User login(String username, String password) throws IncorrectCredentialsException {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_ID, FIRST_NAME, LAST_NAME FROM BANK_USER WHERE USERNAME=? AND PASS_WORD=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				user = new User(userId, username, password, firstname, lastname);
			} else {
				throw new IncorrectCredentialsException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<Account> getAccountsById(int id) {
		PreparedStatement pstmt = null;
		List<Account> accounts = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			accounts = new ArrayList<Account>();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int accId = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				String accName = rs.getString("ACCOUNT_NAME");
				
				accounts.add(new Account(accId, id, balance, accName));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public List<User> superGetUsers() {
		PreparedStatement pstmt = null;
		List<User> users = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			users = new ArrayList<User>();
			String sql = "SELECT * FROM BANK_USER";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASS_WORD");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				
				users.add(new User(userId, username, password, firstname, lastname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASS_WORD");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				
				user = new User(id, username, password, firstname, lastname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	private User getUserByUsername(String username) {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("USER_ID");
				String password = rs.getString("PASS_WORD");
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				
				user = new User(id, username, password, firstname, lastname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void superChangeUser(User user) throws IllegalUsernameException, IllegalPasswordException {
		User user2 = this.getUserByUsername(user.getUsername());
		for (User u : this.superGetUsers()) {
			if (u.getUsername().equals(user.getUsername()) && user.getuserId() != user2.getuserId()) {
				throw new IllegalUsernameException();
			}
		}
		if (user.getPassword().length() < 8) {
			throw new IllegalPasswordException();
		}
		
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE BANK_USER SET USERNAME=?, PASS_WORD=?, "
					+ "FIRST_NAME=?, LAST_NAME=? WHERE USER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setInt(5, user.getuserId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void superDeleteUser(User user) {
		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "DELETE FROM BANK_USER WHERE USER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, this.getUserByUsername(user.getUsername()).getuserId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
