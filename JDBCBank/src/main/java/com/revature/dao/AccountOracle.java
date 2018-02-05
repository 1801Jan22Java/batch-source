package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import com.revature.beans.Accounts;
import com.revature.util.AccountIdNotValidException;
import com.revature.util.AccountNotEmptyException;
import com.revature.util.ConnectionUtil;
import com.revature.util.OverDraftException;

public class AccountOracle implements AccountDAO {

	private String filename = "connection.properties";

	public boolean newAccount(int userid, int accounttype) {

		String dml = "INSERT INTO ACCOUNTS(account_type, USER_ID) " + "VALUES(?,?)";

		PreparedStatement pstate = null;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {

			pstate = conn.prepareStatement(dml);
			pstate.setInt(1, accounttype);
			pstate.setInt(2, userid);
			if (pstate.executeUpdate() > 0) {
				System.out.println("Account created.");
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Invalid account or user ID");
		} catch (IOException e) {
			System.out.println("Connection aborted.");
		}
		return false;

	}

	// Delete an account if empty
	public boolean deleteAccount(int userId, int accountId) {

		// Balance check sql
		String sql = "SELECT BALANCE FROM ACCOUNTS " + "WHERE USER_ID = ? AND ACCOUNT_ID = ?";
		// Deletion dml
		String dml = "DELETE FROM ACCOUNTS " + "WHERE USER_ID = ? AND ACCOUNT_ID = ?";

		PreparedStatement pcheck = null;
		PreparedStatement pstate = null;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {

			pcheck = conn.prepareStatement(sql);
			pcheck.setInt(1, userId);
			pcheck.setInt(2, accountId);
			ResultSet rcheck = pcheck.executeQuery();

			// Exit if account doesn't exist
			while (!rcheck.next()) {
				throw new AccountNotFoundException("No such account found.");
			}

			if (rcheck.getInt("BALANCE") != 0) {
				throw new AccountNotEmptyException();
			}

			pstate = conn.prepareStatement(dml);
			pstate.setInt(1, userId);
			pstate.setInt(2, accountId);
			if (pstate.executeUpdate() > 0) {
				System.out.println("Account deleted.");
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("Invalid account or user ID");
		} catch (IOException e) {
			System.out.println("Connection aborted.");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (AccountNotEmptyException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	// Display accounts
	public ArrayList<Accounts> getAccounts(Integer userid) {
		ArrayList<Accounts> accountList = new ArrayList<>();
		String sql = "SELECT ACCOUNTS.ACCOUNT_ID, BALANCE, TYPE " + "FROM ACCOUNTS, BANK_USERS,ACCOUNT_TYPE A "
				+ "WHERE ACCOUNTS.USER_ID = BANK_USERS.USER_ID " + "AND ACCOUNTS.USER_ID = ? "
				+ "AND A.ACCOUNT_TYPE_ID = ACCOUNTS.ACCOUNT_TYPE";
		PreparedStatement pstate = null;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {

			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, userid);
			ResultSet rs = pstate.executeQuery();

			while (rs.next()) {
				double balance = rs.getDouble("BALANCE");
				String accountType = rs.getString("TYPE");
				int accountId = rs.getInt("ACCOUNT_ID");
				accountList.add(new Accounts(accountId, accountType, userid, balance));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountList;

	}

	// Deposit money to account
	public boolean deposit(Integer userid, Integer accountid, Double amount) {
		String sec = "SELECT ACCOUNTS.ACCOUNT_ID FROM ACCOUNTS, BANK_USERS WHERE ACCOUNTS.USER_ID = BANK_USERS.USER_ID AND ACCOUNTS.USER_ID = ? AND ACCOUNT_ID = ?";
		String sql = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		String dml = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNT_ID = ?";
		PreparedStatement verify = null;
		PreparedStatement pstate = null;
		PreparedStatement check = null;
		Double balance = 0.00;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			// Check legitimacy of input account
			verify = conn.prepareStatement(sec);
			verify.setInt(1, userid);
			verify.setInt(2, accountid);
			ResultSet verifyRs = verify.executeQuery();
			// If account doesn't exist, throw exception.
			while (!verifyRs.next()) {
				throw new AccountIdNotValidException();
			}

			// Check account balance
			check = conn.prepareStatement(sql);
			check.setInt(1, accountid);
			ResultSet rs = check.executeQuery();

			while (rs.next()) {
				balance = rs.getDouble("BALANCE");
			}

			if (amount <= 0) {
				System.out.println("Deposited " + amount.toString() + "\nBalance: " + balance);
			} else {
				pstate = conn.prepareStatement(dml);
				double newamount = balance + amount;
				pstate.setDouble(1, newamount);
				pstate.setInt(2, accountid);
				pstate.executeUpdate();
				System.out.println("Deposited " + amount.toString() + "\nBalance: " + newamount);
				rs.close();
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AccountIdNotValidException e) {
			System.out.println(e.getMessage());
		}
		// If runtime makes it to here, there was an exception along the way.
		return false;
	}

	public boolean withdraw(Integer userid, Integer accountid, Double amount) {
		String sec = "SELECT ACCOUNTS.ACCOUNT_ID FROM ACCOUNTS, BANK_USERS WHERE ACCOUNTS.USER_ID = BANK_USERS.USER_ID AND ACCOUNTS.USER_ID = ? AND ACCOUNT_ID = ?";
		String sql = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		String dml = "UPDATE ACCOUNTS" + " SET BALANCE = ? " + "WHERE ACCOUNT_ID = ?";
		PreparedStatement verify = null;
		PreparedStatement pstate = null;
		PreparedStatement check = null;
		Double balance = 0.00;
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			// Check legitimacy of input account
			verify = conn.prepareStatement(sec);
			verify.setInt(1, userid);
			verify.setInt(2, accountid);
			ResultSet verifyRs = verify.executeQuery();
			// If account doesn't exist, throw exception.
			while (!verifyRs.next()) {
				throw new AccountIdNotValidException();
			}

			// Check account balance
			// Make sure overdrafting does not happen.
			check = conn.prepareStatement(sql);
			check.setInt(1, accountid);
			ResultSet rs = check.executeQuery();

			while (rs.next()) {
				balance = rs.getDouble("BALANCE");
			}

			if (amount <= 0) {
				System.out.println("Withdrew " + amount.toString() + "\nBalance: " + balance);
			} else if (balance >= amount) {
				pstate = conn.prepareStatement(dml);
				double newamount = balance - amount;
				pstate.setDouble(1, newamount);
				pstate.setInt(2, accountid);
				pstate.executeUpdate();
				System.out.println("Withdrew " + amount.toString() + "\nBalance: " + newamount);
				rs.close();
			} else {
				throw new OverDraftException();
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OverDraftException e) {
			System.out.println(e.getMessage());
		} catch (AccountIdNotValidException e) {
			System.out.println(e.getMessage());
		}
		// If runtime makes it to here, there was an exception along the way.
		return false;
	}

}
