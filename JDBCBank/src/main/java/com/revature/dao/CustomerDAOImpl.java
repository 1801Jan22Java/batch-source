package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	private static String filename = "connection.properties";

	@Override
	public Customer getCustByUsername(String username) {
		PreparedStatement pstmt = null;
		Customer currentCustomer = null;
		AccountDAOImpl accessAccount = new AccountDAOImpl();
		Account account = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM CUSTOMER WHERE USER_NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String name = rs.getString("USER_NAME");
				String password = rs.getString("USER_PASS");
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				account = accessAccount.getByAccountId(accountId);
				int isSuper = rs.getInt("ISSUPER");
				int isLogin = rs.getInt("ISLOGIN");
				currentCustomer = new Customer(name, password, id, account, isSuper, isLogin);
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return currentCustomer;
	}

	@Override
	public void createNewCustomer(String username, String password) {

		System.out.println("Adding user...");

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "INSERT INTO CUSTOMER  (USER_NAME, USER_PASS) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("User added!");
	}

	@Override
	public int getSuperStatus(String username) {
		
		int isSuperValue = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM CUSTOMER WHERE USER_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				isSuperValue = rs.getInt("ISSUPER");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isSuperValue;
	}

	@Override
	public String validatePassword(String username) {
		String passInDB = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM CUSTOMER WHERE USER_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				passInDB = rs.getString("USER_PASS");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return passInDB;		
	}

}
