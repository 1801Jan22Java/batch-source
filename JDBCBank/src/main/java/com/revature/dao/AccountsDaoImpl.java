package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


import com.revature.beans.Accounts;
import com.revature.main.NotEnoughFundsException;
import com.revature.util.ConnectionUtil;


public class AccountsDaoImpl implements AccountsDao {
	
	private static String filename = "connection.properties";
	
	@Override
	public Accounts getAccountByID(int ID) {
		
		return null;
	}

	//This returns all accounts associated with a single user
	@Override
	public ArrayList<Accounts> getAllUserAccounts(int ID) {
		ArrayList<Accounts> userAccs = new ArrayList<Accounts>();
		ArrayList<Integer> accNames = new ArrayList<Integer>();
		AccountsDaoImpl adi = new AccountsDaoImpl();
		accNames = adi.getAllBankIDsPerUser(ID);
		if (accNames == null)
			return null;
		for (int i : accNames)
		{
			Connection con = null;
			try {
				con = ConnectionUtil.getConnectionFromFile(filename);
				String sql = "SELECT * FROM ACCOUNTS WHERE BANK_ACCOUNT_ID = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,  i);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
				{
					int bankAccountID = rs.getInt("BANK_ACCOUNT_ID");
					int bankAccountType = rs.getInt("BANK_ACCOUNT_TYPE");
					float currencyAmount = rs.getFloat("CURRENCY_AMOUNT");
					userAccs.add(new Accounts(bankAccountID, bankAccountType, currencyAmount));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		return userAccs;
	}

	//This returns all the bank account ID's associated with a user
	@Override
	public ArrayList<Integer> getAllBankIDsPerUser(int ID) {
		ArrayList<Integer> userAccsIDs = new ArrayList<Integer>();
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);		
			String sql = "SELECT BANK_ACCOUNT_ID FROM USER_ACCOUNTS WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				userAccsIDs.add(rs.getInt("BANK_ACCOUNT_ID"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return userAccsIDs;
	}

	//This will create a new bank account and utilize a sequence to create a new ID for it
	@Override
	public int createAccount(int type, float currAmnt) {
		int createAccount = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO ACCOUNTS (BANK_ACCOUNT_ID, BANK_ACCOUNT_TYPE, CURRENCY_AMOUNT)"+
			" VALUES(ACC_NUM_SEQ.NEXTVAL,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  type);
			pstmt.setFloat(2,  currAmnt);
			createAccount = pstmt.executeUpdate();
			sql = "SELECT ACC_NUM_SEQ.CURRVAL FROM DUAL";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				createAccount = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		return createAccount;
	}


	//This will add money to a bank account
	@Override
	public Accounts addFunds(Accounts acc, float amnt) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE ACCOUNTS SET CURRENCY_AMOUNT = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1,  amnt + acc.getCurrencyAmount());
			pstmt.setInt(2, acc.getBankAccountID());
			pstmt.executeUpdate();
			acc.setCurrencyAmount(acc.getCurrencyAmount()+amnt);
			return acc;
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return acc;
	}

	//This will remove money from a bank account
	//If a user does not have the required funds an error will be thrown
	@Override
	public Accounts removeFunds(Accounts acc, float amnt) throws NotEnoughFundsException {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE ACCOUNTS SET CURRENCY_AMOUNT = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, acc.getCurrencyAmount() - amnt);
			pstmt.setInt(2, acc.getBankAccountID());
			pstmt.executeUpdate();
			acc.setCurrencyAmount(acc.getCurrencyAmount()-amnt);
			return acc;
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (acc == null)
			throw new NotEnoughFundsException();
		return acc;
	}
	
	
	
}


