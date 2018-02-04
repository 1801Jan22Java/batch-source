package com.revature.JDBCBank;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.*;

import com.revature.beans.Accounts;
import com.revature.dao.AccountOracle;
import com.revature.util.ConnectionUtil;

public class AccountOracleTest {

	// Just print out account info
	@Test
	public void printAccounts() {
		AccountOracle accountOps = new AccountOracle();
		ArrayList<Accounts> accounts = accountOps.getAccounts(1);
		for (Accounts acc : accounts) {
			acc.printAccount();
		}
	}

	// Check overdraft protection
	@Test
	public void withdrawReturnMessageOnOverdraft() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.withdraw(1, 1, 9999999.00);
		assertFalse(check);
	}

	// Withdraw negative amount
	// Test Deposit to account
	@Test
	public void withdrawNegativeAmount() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.withdraw(1, 1, -100.00);
		assertTrue(check);
	}

	// Deposit negative amount
	// Test Deposit to account
	@Test
	public void depositNegativeAmount() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.deposit(1, 1, -100.00);
		assertTrue(check);
	}

	// Test access to wrong account
	@Test
	public void notAllowWrongAccountAccess() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.withdraw(1, 15, 0.0);
		assertFalse(check);
	}

	// Test access to right account with successful transaction
	@Test
	public void withdrawSuccessful() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.withdraw(1, 1, 0.00);
		assertTrue(check);
	}

	// Test Deposit to account
	@Test
	public void depositGreaterThanZeroSuccessful() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.deposit(1, 1, 100.00);
		assertTrue(check);
	}

	// Test Deposit to account with 0
	@Test
	public void depositZeroSuccessful() {
		AccountOracle ao = new AccountOracle();
		boolean check = ao.deposit(1, 1, 0.00);
		assertTrue(check);
	}

	// Test Account creation
	@Test
	public void createAccountWithValidValues() {
		AccountOracle ao = new AccountOracle();
		assertTrue(ao.newAccount(1, 2));
	}

	@Test
	public void createAccountWithInvalidType() {
		AccountOracle ao = new AccountOracle();
		assertFalse(ao.newAccount(1, 22));
	}

	@Test
	public void createAccountWithInvalidAccount() {
		AccountOracle ao = new AccountOracle();
		assertFalse(ao.newAccount(1000, 1));
	}

	// Test Account deletion
	// Account balance must be 0
	@Test
	public void deleteEmptyAccount() {
		AccountOracle ao = new AccountOracle();
		ao.newAccount(1, 1);
		int accountid = 1;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			// SQL to select max id of the newest account for testing
			String sql = "SELECT MAX(ACCOUNT_ID) AS ID FROM ACCOUNTS WHERE USER_ID = 1";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				accountid = rs.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(ao.deleteAccount(1, accountid));
	}

	@Test
	public void deleteNonEmptyAccount() {
		AccountOracle ao = new AccountOracle();
		ao.newAccount(1, 1);
		
		int accountid = 1;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			// SQL to select max id of the newest account for testing
			String sql = "SELECT MAX(ACCOUNT_ID) AS ID FROM ACCOUNTS WHERE USER_ID = 1";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				accountid = rs.getInt("ID");
			}
			ao.deposit(1, accountid, 10.0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(ao.deleteAccount(1, accountid));
		ao.withdraw(1, accountid, 10.0);
		ao.deleteAccount(1, accountid);
	}
	
	@Test
	public void deleteWrongAccountId() {
		AccountOracle ao = new AccountOracle();

		assertFalse(ao.deleteAccount(1, 3));
	}

}
