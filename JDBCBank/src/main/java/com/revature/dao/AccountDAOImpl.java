package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	
	private static String filename = "connection.properties";

	@Override
	public Account getByAccountId(int accountId) {
		
		PreparedStatement pstmt = null;
		Account account = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				double balance = rs.getDouble("BALANCE");
				account = new Account(accountId, balance);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void addAccount(double amount) {
		System.out.println("Creating account");
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO BANKACCOUNT (BALANCE) VALUES (?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Account created");		
	}

	
}
