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

public class AccountTypeDaoImpl implements AccountTypeDao{

	private static String filename = "connection.properties";
		
	/* 
	 * 
	 */
	@Override
	public List<AccountType> getAccountTypes()
	{
		List<AccountType> at1 = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM ACCOUNT_TYPE";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("ACCOUNT_TYPE_ID");
				String type = rs.getString("ACCOUNT_TYPE");
				AccountType newAT = new AccountType(id,type);
				at1.add(newAT);
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
		return at1;
	}

	/* 
	 * 
	 */
	@Override
	public AccountType getAccountTypeById(int id) {
		// 
		PreparedStatement pstmt = null;
		AccountType at = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			String sql = "SELECT * FROM ACCOUNT_TYPE WHERE ACCOUNT_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("ACCOUNT_TYPE");
				at = new AccountType(id, name);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return at;
	}
	
	

}
