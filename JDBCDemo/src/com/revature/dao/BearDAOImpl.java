package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;


import com.revature.beans.Bear;
import com.revature.util.ConnectionUtil;

public class BearDAOImpl implements BearDAO{
	
	private static String filename ="connection.properties";

	@Override
	public List<Bear> getBears() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addBear(Bear b) {
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BEAR"
					+ "(BEAR_ID, BEAR_TYPE_ID, BEAR_NAME, BEAR_BIRTHDATE, BEAR_WEIGHT, CAVE_ID)"
					+ " VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, b.getId());
			pstmt.setInt(2, b.getBearType().getId());
			pstmt.setString(3, b.getName());
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pstmt.setDate(4, sqlDate);
			pstmt.setInt(5, b.getWeight());
			pstmt.setInt(6, b.getCave().getId());
			pstmt.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
