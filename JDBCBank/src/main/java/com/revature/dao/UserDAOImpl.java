package com.revature.dao;

import java.util.List;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;
import com.revature.beans.User;

public class UserDAOImpl implements UserDAO {

	private final String filename = "connection.properties";

	@Override
	public User createUser(User user) {
		PreparedStatement stmnt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "INSERT INTO BANK_USER (FIRST_NAME, LAST_NAME, USER_PASSWORD, USERNAME, SUPERUSER) "
					+ "VALUES (?, ?, ?, ?, 0)";

			stmnt = con.prepareStatement(sql);
			stmnt.setString(1, user.getFirstName());
			stmnt.setString(2, user.getLastName());
			stmnt.setString(3, user.getPassword());
			stmnt.setString(4, user.getUserName());
			stmnt.executeUpdate();

			sql = "SELECT USER_ID FROM BANK_USER WHERE USERNAME = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setString(1, user.getUserName());
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("USER_ID"));
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getUsers() {

		List<User> users = new ArrayList<>();
		PreparedStatement stmnt = null;
		AccountDAO acctDao = new AccountDAOImpl();
		int id;
		int su;
		boolean superuser;
		String firstName;
		String lastName;
		String userName;
		String password;
		List<Account> accts = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER";
			stmnt = con.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("USER_ID");
				firstName = rs.getString("FIRST_NAME");
				lastName = rs.getString("LAST_NAME");
				userName = rs.getString("USERNAME");
				password = rs.getString("USER_PASSWORD");
				su = rs.getInt("SUPERUSER");
				accts = acctDao.getAccountsByUserId(id);
				if (su == 0) {
					superuser = false;
				} else {
					superuser = true;
				}
				users.add(new User(id, firstName, lastName, userName, password, superuser, accts));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public User getUserById(int userId) {
		User user = null;
		PreparedStatement stmnt = null;
		AccountDAO acctDao = new AccountDAOImpl();
		int id;
		int su;
		boolean superuser;
		String firstName;
		String lastName;
		String userName;
		String password;
		List<Account> accts = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USER_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, userId);
			ResultSet rs = stmnt.executeQuery();

			if (rs.next()) {
				id = rs.getInt("USER_ID");
				firstName = rs.getString("FIRST_NAME");
				lastName = rs.getString("LAST_NAME");
				userName = rs.getString("USERNAME");
				password = rs.getString("USER_PASSWORD");
				su = rs.getInt("SUPERUSER");
				accts = acctDao.getAccountsByUserId(id);
				if (su == 0) {
					superuser = false;
				} else {
					superuser = true;
				}
				user = new User(id, firstName, lastName, userName, password, superuser, accts);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void deleteUser(User user) {

		PreparedStatement stmnt = null;
		AccountDAO acctDao = new AccountDAOImpl();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			for (Account acct : user.getAccounts()) {
				acctDao.deleteAccount(acct.getId());
			}

			String sql = "DELETE FROM BANK_USER WHERE USER_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, user.getId());
			stmnt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User signIn(String userName, String password) {

		User user = null;
		PreparedStatement stmnt = null;
		AccountDAO acctDao = new AccountDAOImpl();
		int id;
		int su;
		boolean superuser;
		String firstName;
		String lastName;
		List<Account> accts = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME = ? AND USER_PASSWORD = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setString(1, userName);
			stmnt.setString(2, password);
			ResultSet rs = stmnt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("USER_ID");
				firstName = rs.getString("FIRST_NAME");
				lastName = rs.getString("LAST_NAME");
				su = rs.getInt("SUPERUSER");
				accts = acctDao.getAccountsByUserId(id);
				if (su == 0) {
					superuser = false;
				} else {
					superuser = true;
				}
				user = new User(id, firstName, lastName, userName, password, superuser, accts);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement stmnt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE BANK_USER SET FIRST_NAME = ?, LAST_NAME = ?, USER_PASSWORD = ? "
					+ "WHERE USER_ID = ?";

			stmnt = con.prepareStatement(sql);
			stmnt.setString(1, user.getFirstName());
			stmnt.setString(2, user.getLastName());
			stmnt.setString(3, user.getPassword());
			stmnt.setInt(4, user.getId());
			stmnt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		PreparedStatement stmnt = null;
		int id;
		int su;
		boolean superuser;
		String firstName;
		String lastName;
		String userName;
		String password;
		List<Account> accts = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setString(1, username);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("USER_ID");
				firstName = rs.getString("FIRST_NAME");
				lastName = rs.getString("LAST_NAME");
				userName = rs.getString("USERNAME");
				password = rs.getString("USER_PASSWORD");
				su = rs.getInt("SUPERUSER");
				if (su == 0) {
					superuser = false;
				} else {
					superuser = true;
				}
				user = new User(id, firstName, lastName, userName, password, superuser, accts);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

}
