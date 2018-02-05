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
import com.revature.util.ConnectionUtil;
import com.revature.util.IllegalAmountException;
import com.revature.util.IllegalDeleteException;
import com.revature.util.IllegalWithdrawException;

public class AccountDaoImpl implements AccountDao {
	
	private final String filename = "connection.properties";

	@Override
	public void createAccount(Account acc) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL CREATE_ACCOUNT(?, ?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, acc.getUserId());
			cstmt.setDouble(2, acc.getBalance());
			cstmt.setString(3, acc.getAccName());
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Account> getUserAccounts(int userId) {
		PreparedStatement pstmt = null;
		List<Account> accounts = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			accounts = new ArrayList<Account>();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int accId = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				String accName = rs.getString("ACCOUNT_NAME");
				accounts.add(new Account(accId, userId, balance, accName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public Account getAccountById(int id) {
		PreparedStatement pstmt = null;
		Account account = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("USER_ID");
				double balance = rs.getDouble("BALANCE");
				String accName = rs.getString("ACCOUNT_NAME");
				
				account = new Account(id, userId, balance, accName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public void delete(int id) throws IllegalDeleteException {
		Account acc = this.getAccountById(id);
		if (acc.getBalance() != 0.0) {
			throw new IllegalDeleteException();
		}
		
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL REMOVE_ACCOUNT(?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, id);
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(int id, double amt) throws IllegalAmountException {
		if (amt < 0.0) {
			throw new IllegalAmountException();
		}
		
		this.updateByAmount(id, amt);
	}

	@Override
	public void withdraw(int id, double amt) throws IllegalWithdrawException, IllegalAmountException {
		if (amt < 0.0) {
			throw new IllegalAmountException();
		}
		Account acc = this.getAccountById(id);
		if (acc.getBalance() - amt < 0.0) {
			throw new IllegalWithdrawException();
		}
		
		this.updateByAmount(id, -amt);
	}
	
	private void updateByAmount(int id, double amt) {
		CallableStatement cstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{CALL UPDATE_BY_AMOUNT(?, ?)}";
			
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, id);
			cstmt.setDouble(2, amt);
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
