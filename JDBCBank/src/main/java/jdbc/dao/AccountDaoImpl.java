package jdbc.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.ConnectionUtil;
import jdbc.beans.Account;

public class AccountDaoImpl implements AccountDao {

	String filename = "connection.properties";

	public List<Account> getAccountsByUserId(int user) {
		List<Account> userAccs = new ArrayList<Account>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("ACCOUNTID");
				int j = rs.getInt("USERID");
				int k = rs.getInt("BALANCE");
				userAccs.add(new Account(i, j, k));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAccs;
	}

	public Account getAccountById(int acctId) {
		Account acct = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acctId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("ACCOUNTID");
				int j = rs.getInt("USERID");
				int k = rs.getInt("BALANCE");
				acct = new Account(i, j, k);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acct;
	}
	
	public int getUserIdByAccountId(int acctId) {
		int i = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USERID FROM ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acctId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				i = rs.getInt("USERID");
				return i;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void withdraw(int amount, int acctId) {
		Account a = getAccountById(acctId);
		if (a.getBalance() > amount) {
			try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
				String sql = "{call WITHDRAW(?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, amount);
				cs.setInt(2, acctId);
				cs.execute();
				a = getAccountById(acctId);
				System.out.println("new balance: " + a.getBalance());
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out
					.println("your funds are too low to withdraw that much, you only have " + a.getBalance() + " left");
		}
	}

	public void deposit(int acctId, int amount) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{call DEPOSIT(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, amount);
			cs.setInt(2, acctId);
			cs.execute();
			con.close();
			System.out.println("successfully deposited " + amount + " into the account");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createAccount(int userId) {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO ACCOUNT (USERID, BALANCE) VALUES(?,0)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("new account created");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(int acctId) {

		Account a = getAccountById(acctId);
		if (a.getBalance() == 0) {
			try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
				String sql = "DELETE FROM ACCOUNT WHERE ACCOUNTID = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, acctId);
				pstmt.executeQuery();
				System.out.println("account successfully deleted");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("that account still has money in it and therefore can't be deleted.\n"
					+ " withdraw remaining " + a.getBalance() + " to delete this account");
		}

	}

}
