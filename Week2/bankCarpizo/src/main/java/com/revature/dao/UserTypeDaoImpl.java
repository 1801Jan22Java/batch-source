package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.UserType;
import com.revature.util.ConnectionUtil;

public class UserTypeDaoImpl implements UserTypeDao
{
	private static String filename = "connection.properties";

	public List<UserType> getUserTypes() 
	{
		List<UserType> userTypes = new ArrayList<UserType>();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM USER_TYPES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("USER_TYPE_ID");
				String type = rs.getString("TYPE_NAME");
				userTypes.add(new UserType(id,type));
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
		return userTypes;
	}

	public UserType getUserTypeById(int id)
	{
		UserType userType = new UserType();
		PreparedStatement pstmt = null;

		try{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM USER_TYPES WHERE USER_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String type = rs.getString("TYPE_NAME");
				userType = new UserType(id,type);
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
		return userType;
	}
}
