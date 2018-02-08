package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.AccountType;
import com.revature.util.ConnectionUtil;

public class AccountTypeDaoImpl implements AccountTypeDao 
{
	private static String filename = "connection.properties";

	public List<AccountType> getAllAccountTypes()
	{
		List<AccountType> accountTypes = new ArrayList<AccountType>();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNT_TYPES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("BANK_ACCOUNT_TYPE_ID");
				String type = rs.getString("TYPE_NAME");
				accountTypes.add(new AccountType(id,type));
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return accountTypes;
	}

	public AccountType getAccountTypeById(int id) 
	{
		AccountType accountType = new AccountType();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNT_TYPES WHERE BANK_ACCOUNT_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String type = rs.getString("TYPE_NAME");
				accountType = new AccountType(id,type);
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		return accountType;
	}
}
