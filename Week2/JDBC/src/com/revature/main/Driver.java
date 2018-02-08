package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver 
{
	public static void main(String args[])
	{
		/*
		Connection connection = null;
		
		try
		{
			connection = ConnectionUtil.getConnectionFromFile("connection.properties");
			//System.out.println(connection.getMetaData().getDriverName());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(1));
		BearDao bd = new BearDaoImpl();
		bd.createBear(1, "Baloo", "DEFAULT", 570, 1);
		System.out.println(bd.getBearById(1));
	}
}
