package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDaoImpl implements CaveDao {
	private static String filename = "connection.properties";
	public List<Cave>getCaves()
	{
		List<Cave> cl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{
			//using a statement - beware SQL injection
			String sql = "SELECT  * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("In while loop");
				int id=rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				cl.add(new Cave(id,name,maxBears));
			}
			con.close();
		}
		catch(SQLException e){}
		catch (IOException e){}
		return cl;
	}
	@Override
	public Cave getCaveById(int id)
	{

		Cave cave = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile())
		{

			PreparedStatement prepStmt = con.prepareStatement("SELECT * FROM CAVE WHERE CAVE_ID="+id);
			prepStmt.execute();
			ResultSet rs= prepStmt.getResultSet();
			/*
		while(rs.next())
		{
			System.out.println("In while loop");
			 rsid=rs.getInt("CAVE_ID");
			 maxBears=rs.getInt("MAX_BEARS");
			 name=rs.getString("CAVE_NAME");


		}*/
			if(rs.next())
			{
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int rsid=rs.getInt("CAVE_ID");

				cave=new Cave(rsid,name,maxBears);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		finally{
			return cave;
		}
	}
}
