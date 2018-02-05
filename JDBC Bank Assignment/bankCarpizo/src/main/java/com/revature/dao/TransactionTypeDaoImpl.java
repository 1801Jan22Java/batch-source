package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.TransactionType;
import com.revature.util.ConnectionUtil;

public class TransactionTypeDaoImpl implements TransactionTypeDao
{
	private static String filename = "connection.properties";

	public List<TransactionType> getAllTransactionTypes() 
	{
		List<TransactionType> transactionTypes = new ArrayList<TransactionType>();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM TRANSACTION_TYPE";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("TRANSACTION_TYPE_ID");
				String type = rs.getString("NAME");
				transactionTypes.add(new TransactionType(id,type));
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
		return transactionTypes;
	}

	public TransactionType getTransactionTypeById(int id) 
	{
		TransactionType transactionType = new TransactionType();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM TRANSACTION_TYPE WHERE TRANSACTION_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String type = rs.getString("NAME");
				transactionType = new TransactionType(id,type);
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
		return transactionType;
	}

}
