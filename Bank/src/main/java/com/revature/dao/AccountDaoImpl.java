package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	private static String filename = "connection.properties";

	@Override
	public boolean addAccount(User myUser, String accountType, String accountName) {
		CallableStatement cs = null;
		int accountsCreated = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{ call add_account(?, ?, ?, ?, ?) }";
			cs = con.prepareCall(sql);
			cs.setString(1, accountType);
			cs.setString(2, accountName);
			cs.setInt(3, myUser.getUserid());
			cs.registerOutParameter(4, Types.NUMERIC);
			cs.registerOutParameter(5, Types.DATE);
			// Save number returned from insert statement
			accountsCreated = cs.executeUpdate();
			int accountid = cs.getInt(4);
			LocalDate creationDate = cs.getDate(5).toLocalDate();
			myUser.getAccounts().add(new Account(accountid, accountType, accountName, 0f, creationDate));
			con.close();
		} catch (SQLException e) {
			System.out.println("could not create new account.");
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// If nothing was returned by the insert statement, then it didn't work
		if (accountsCreated == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean getAccounts(User myUser) {
		myUser.getAccounts().clear();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT a.creation_date, a.accountid, a.balance, a.name, c.keyword " + 
					"FROM user_account u " + 
					"INNER JOIN accounts a ON u.accountid = a.accountid " + 
					"INNER JOIN common_lookup c ON a.account_type = c.common_lookup_id " + 
					"WHERE u.userid = ? " +
					"ORDER BY a.creation_date DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, myUser.getUserid());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				int accountid = rs.getInt("accountid");
				float balance = rs.getFloat("balance");
				String name = rs.getString("name");
				String type = rs.getString("keyword");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				myUser.getAccounts().add(new Account(accountid, type, name, balance, creationDate));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean withdrawAmount(float amount, int currentAccountIndex, User thisUser) {
		CallableStatement cs = null;
		int accountsUpdated = 0;
		float newBalance = 0f;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{ call withdraw(?, ?, ?, ?)";
			cs = con.prepareCall(sql);
			cs.setInt(1, thisUser.getUserid());
			cs.setInt(2, thisUser.getAccounts().get(currentAccountIndex).getAccountid());
			cs.setFloat(3, amount);
			cs.registerOutParameter(4, Types.NUMERIC);
			// Save number returned from insert statement
			accountsUpdated = cs.executeUpdate();
			newBalance = cs.getFloat(4);
			if (accountsUpdated > 0) {
				thisUser.getAccounts().get(currentAccountIndex).setBalance(newBalance);
			}
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean depositAmount(float amount, int currentAccountIndex, User thisUser) {
		CallableStatement cs = null;
		int accountsUpdated = 0;
		float newBalance = 0f;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "{ call deposit(?, ?, ?, ?)";
			cs = con.prepareCall(sql);
			cs.setInt(1, thisUser.getUserid());
			cs.setInt(2, thisUser.getAccounts().get(currentAccountIndex).getAccountid());
			cs.setFloat(3, amount);
			cs.registerOutParameter(4, Types.NUMERIC);
			// Save number returned from insert statement
			accountsUpdated = cs.executeUpdate();
			newBalance = cs.getFloat(4);
			if (accountsUpdated > 0) {
				thisUser.getAccounts().get(currentAccountIndex).setBalance(newBalance);
			}
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}


	
	@Override
	public boolean closeAccount(int currentAccountIndex, User thisUser) {
		PreparedStatement pstmt = null;
		int accountsDeleted = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM user_account WHERE accountid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisUser.getAccounts().get(currentAccountIndex).getAccountid());
			// Save number returned from insert statement
			accountsDeleted = pstmt.executeUpdate();
			if (accountsDeleted > 0) {
				thisUser.getAccounts().remove(currentAccountIndex);
			}
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return true;
	}

}
