package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.AccountNotEmptyException;
import com.revature.util.ConnectionUtil;
import com.revature.util.InvalidAccountIdException;

public class AccountDaoImpl implements AccountDao {

	public static final String filename = "connection.properties";

	public ArrayList<Account> getAccounts(User u) {
		ArrayList<Account> accs = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			accs = new ArrayList<Account>();
			int usr = u.getUserID();
			int valid = 0;
			int aid = 0;
			Double amount = 0.0;
			Double interest = 0.0;
			String accountType = new String();
			String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, usr);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valid = rs.getInt("ACTIVE");
				if (valid > 0) {
					aid = rs.getInt("ACCOUNTID");
					accountType = rs.getString("ACCOUNTTYPE");
					amount = rs.getDouble("BALANCE");
					interest = rs.getDouble("INTEREST");
					LocalDate when = rs.getDate("STARTDAY").toLocalDate();
					accs.add(new Account(aid, accountType, amount, interest, accountType, when));
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accs;
	}

	public Account getAccountByID(int id) throws InvalidAccountIdException {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int valid = 0;
			int aid = id;
			Double amount = 0.0;
			Double interest = 0.0;
			String accountType = new String();
			String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				valid = rs.getInt("ACTIVE");
				if (valid > 0) {
					aid = rs.getInt("ACCOUNTID");
					accountType = rs.getString("ACCOUNTTYPE");
					amount = rs.getDouble("BALANCE");
					interest = rs.getDouble("INTEREST");
					LocalDate when = rs.getDate("STARTDAY").toLocalDate();
					con.close();
					return new Account(aid, accountType, amount, interest, accountType, when);
				}
			} else {
				con.close();
				throw new InvalidAccountIdException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addAccount(Account a, User u) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int uid = u.getUserID();
			String type = a.getAccountType();
			Double amt = a.getBalance();
			Double interest = a.getInterestRate();
			LocalDate dayMade = a.getCreationDate();
			int active = 1;

			String sql = "INSERT INTO ACCOUNT (USERID, ACCOUNTTYPE, BALANCE, INTEREST, STARTDAY, ACTIVE)"
					+ " VALUES (?,?,?,?,?,?)";
			PreparedStatement cs = con.prepareStatement(sql);
			System.out.println("USER ID IS : " + uid);
			cs.setInt(1, uid);
			cs.setString(2, type);
			cs.setDouble(3, amt);
			cs.setDouble(4, interest);
			cs.setDate(5, java.sql.Date.valueOf(dayMade));
			cs.setInt(6, active);
			cs.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteAccount(Account a) throws AccountNotEmptyException, InvalidAccountIdException {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			int aid = a.getAccountID();
			Double amount = 0.0;
			String sql0 = "SELECT Balance FROM ACCOUNT WHERE ACCOUNTID = ?";
			String sql1 = "{call deactivate_account (?)}";

			PreparedStatement ps = con.prepareStatement(sql0);
			CallableStatement cs = con.prepareCall(sql1);
			ps.setInt(1, aid);
			cs.setInt(1, aid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				amount = rs.getDouble(1);
				if (amount != 0.0) {
					con.close();
					throw new AccountNotEmptyException();
				}
			} else {
				con.close();
				throw new InvalidAccountIdException();
			}
			int numberUpdated = 0;
			cs = con.prepareCall(sql1);
			numberUpdated = cs.executeUpdate();
			System.out.println("Number of rows updated: " + numberUpdated);

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
