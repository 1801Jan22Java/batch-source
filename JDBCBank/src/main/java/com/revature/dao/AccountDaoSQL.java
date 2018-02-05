package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoSQL implements AccountDao {

	@Override
	public List<Account> getAccount() {
		
		List<Account> resultAccounts = new ArrayList<Account>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			Account result;
			String sql = "SELECT * FROM ACCOUNT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accId = rs.getInt("ACCOUNTID");
				int bnkId = rs.getInt("BANKUSERID");
				int type  = rs.getInt("TYPE");
				int balId = rs.getInt("BALANCEID");
				result = new Account(accId,bnkId,type,balId);
				System.out.println("Found: " + result.toString());
				resultAccounts.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultAccounts;
	}

	@Override
	public Account getAccountByID(int id) {
		Account result = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accId = rs.getInt("ACCOUNTID");
				int bnkId = rs.getInt("BANKUSERID");
				int type  = rs.getInt("TYPE");
				int balId = rs.getInt("BALANCEID");
				result = new Account(accId,bnkId,type,balId);
				System.out.println("Found: " + result.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addAccount(int userid, int type, double initialAmount) {

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call NEW_ACCOUNT(0,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, userid);
			cs.setInt(2,type);
			cs.setDouble(3,initialAmount);
			
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
