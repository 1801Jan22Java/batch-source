package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao {

	private static String filename = "connection.properties";
	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		return bl;
		
	}

	@Override
	public Bear getBearById(int id) {
		Bear bjorn = null;
		return bjorn;
	}

	public void feedBear(int bearID,int beehiveID,int amthoney)
	{
		String sqlStr = "{CALL SP_FEED_BEAR (?,?,?)}";
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename))
		{
	
			CallableStatement cs = conn.prepareCall("");
			cs.setInt(1,bearID);
			cs.setInt(2, beehiveID);
			cs.setInt(3, amthoney);
			cs.execute();
			
			
		} catch (SQLException | IOException e) {
		//	conn.rollback();
			e.printStackTrace();
			
		}
	}
	
	@Override
	public void addBear(Bear bear) {
	

		try(Connection con = ConnectionUtil.getConnectionFromFile(filename))
		{
			con.setAutoCommit(false);
			System.out.println("In try statement");
			java.sql.Date birthday =(java.sql.Date)bear.getBirthdate();
			PreparedStatement prepStmt=con.prepareStatement("INSERT INTO BEAR VALUES(?,?,?,?,?)");
			prepStmt.setString(1,bear.getName());
			prepStmt.setInt(2, bear.getCave().getId());
			prepStmt.setInt(3, bear.getBearType().getId());
			prepStmt.setInt(4,bear.getWeight());
			prepStmt.setDate(5, birthday);	
			prepStmt.execute();
			con.commit();

		} catch (SQLException | IOException e) {
			//con.rollback();
			e.printStackTrace();
		}
		
		
	}
	


}
