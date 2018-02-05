package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.beans.BankUsers;
import com.revature.util.ConnectionUtil;
import com.revature.util.UserNameExistsException;

// Abstract out user operations
public class UserOracle implements UserDAO {

	private String filename = "connection.properties";

	@Override
	public BankUsers login(String username, String password) {
		String sql = "SELECT USER_ID,ROLE_ID,USERNAME FROM BANK_USERS WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement pstate = null;
		BankUsers bu = null;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, username);
			pstate.setString(2, password);
			ResultSet rs = pstate.executeQuery();

			while (rs.next()) {

				// Insert information into BankUsers bean
				int userId = rs.getInt("USER_ID");
				int roleId = rs.getInt("ROLE_ID");
				String uname = rs.getString("USERNAME");
				bu = new BankUsers(userId, roleId, uname);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bu;
	}

	// Create new user
	@Override
	public boolean newUser(String username, String password) {
		String sql = "SELECT USER_ID FROM BANK_USERS WHERE USERNAME = ?";
		String dml = "INSERT INTO BANK_USERS(USERNAME, PASSWORD, LOGGED) VALUES(?,?,0)";
		PreparedStatement pstate = null;
		PreparedStatement pstatementInsert = null;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, username);
			ResultSet rs = pstate.executeQuery();

			// If user account exists, throw a custom exception
			// Otherwise, add new user
			while (rs.next()) {
				throw new UserNameExistsException();
			}

			pstatementInsert = conn.prepareStatement(dml);
			pstatementInsert.setString(1, username);
			pstatementInsert.setString(2, password);
			pstatementInsert.executeUpdate();
			System.out.println("New User Created!");

			rs.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserNameExistsException e) {
			System.out.println(e.getMessage());

		}
		return false;
	}

	@Override
	public boolean deleteUser(int userid) {

		// Use a procedure in order to delete users without being
		CallableStatement cs = null;
		String sql = "{call DELETE_USER(?)}";
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			cs = conn.prepareCall(sql);

			// Insert input user id
			cs.setInt(1, userid);

			cs.executeUpdate();
			System.out.println("Deleted user.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editUser(int userid, int roleid, String username, String password) {
		// Use a procedure in order to delete users without being
		CallableStatement cs = null;
		String sql = "{call UPDATE_USER(?,?,?,?) }";
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			cs = conn.prepareCall(sql);

			// Insert input user id
			cs.setInt(1, userid);
			cs.setInt(2, roleid);
			cs.setString(3, username);
			cs.setString(4, password);

			cs.executeUpdate();
			System.out.println("Edited user.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void showAllUsers() {
		ArrayList<BankUsers> userList = new ArrayList<>();
		PreparedStatement pstate = null;
		String sql = "SELECT USER_ID, ROLE_ID, USERNAME, PASSWORD FROM BANK_USERS";
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			pstate = conn.prepareStatement(sql);
			ResultSet rs = pstate.executeQuery();
			while (rs.next()) {
				int userid = rs.getInt("USER_ID");
				int roleid = rs.getInt("ROLE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USERNAME");
				userList.add(new BankUsers(userid, roleid, username, password));
			}

			for (BankUsers bu : userList) {
				System.out.print("User ID: " + bu.getUserId());
				System.out.print(" Role ID: " + bu.getRoleId());
				System.out.print(" Username: " + bu.getUsername());
				System.out.print(" Password: " + bu.getPassword() + "\n");
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
