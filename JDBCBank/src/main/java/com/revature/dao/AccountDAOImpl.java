package com.revature.dao;

import java.util.List;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import com.revature.beans.Account;
import com.revature.exceptions.OverdraftException;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	private final String filename = "connection.properties";

	@Override
	public void createAcount(Account acct, int userId) {
		CallableStatement stmnt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "{CALL ADD_ACCOUNT(?, ?, ?)}";

			stmnt = con.prepareCall(sql);
			stmnt.setString(1, acct.getName());
			stmnt.setInt(2, acct.getBalance());
			stmnt.setInt(3, userId);
			stmnt.executeUpdate();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Account> getAccounts() {

		List<Account> accts = new ArrayList<>();
		PreparedStatement stmnt = null;
		String name;
		int id;
		int balance;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNT";
			stmnt = con.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ACCOUNT_ID");
				name = rs.getString("ACCOUNT_NAME");
				balance = rs.getInt("AMOUNT");
				accts.add(new Account(id, name, balance));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return accts;
	}

	@Override
	public Account getAccountById(int acctId) {
		Account acct = null;
		PreparedStatement stmnt = null;
		String name;
		int id;
		int balance;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, acctId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ACCOUNT_ID");
				name = rs.getString("ACCOUNT_NAME");
				balance = rs.getInt("AMOUNT");
				acct = new Account(id, name, balance);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return acct;
	}

	@Override
	public List<Account> getAccountsByUserId(int userId) {
		List<Account> accts = new ArrayList<>();
		PreparedStatement stmnt = null;
		String name;
		int id;
		int balance;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNT INNER JOIN BANK_USERXACCOUNT "
					+ "ON ACCOUNT.ACCOUNT_ID = BANK_USERXACCOUNT.ACCOUNT_ID " + 
					"WHERE BANK_USERXACCOUNT.USER_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, userId);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ACCOUNT_ID");
				name = rs.getString("ACCOUNT_NAME");
				balance = rs.getInt("AMOUNT");
				accts.add(new Account(id, name, balance));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return accts;
	}

	@Override
	public void depositAmount(int acctId, int amount) {

		PreparedStatement stmnt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE ACCOUNT SET AMOUNT = (AMOUNT + ?) " + "WHERE ACCOUNT_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, amount);
			stmnt.setInt(2, acctId);
			stmnt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void withdrawAmount(int acctId, int amount) throws OverdraftException {

		CallableStatement stmnt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL WITHDRAW_AMOUNT(?, ?)}";
			stmnt = con.prepareCall(sql);
			stmnt.setInt(1, acctId);
			stmnt.setInt(2, amount);
			stmnt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			if (e.getErrorCode() == 6510) {
				throw new OverdraftException();
			}else {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccount(int acctId) {
		PreparedStatement stmnt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, acctId);
			stmnt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateAccount(Account acct) {
		PreparedStatement stmnt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE ACCOUNT SET AMOUNT = ? AND ACCOUNT_NAME = ? " + "WHERE ACCOUNT_ID = ?";

			stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, acct.getBalance());
			stmnt.setString(2, acct.getName());

			stmnt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
