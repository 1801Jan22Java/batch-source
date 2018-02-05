package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	
	private static String filename = "connection.properties";

	@Override
	public Account getByAccountId(int accountId) {

		Account account = null;
		double acctId=12;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANK_ACCOUNT_ID = ?";
	
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,accountId);
			//pstmt.execute();
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("reached");
				double balance = rs.getDouble("BALANCE");
				System.out.println(balance);
				account = new Account(accountId, balance);
				System.out.println(balance);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return account;
	}
}
