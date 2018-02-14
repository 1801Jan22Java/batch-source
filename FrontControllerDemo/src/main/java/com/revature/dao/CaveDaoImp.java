package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDaoImp implements CaveDao{
	private static String filename = "connection.properties";
	
	public List<Cave> getCaves(){
		List<Cave> c1 = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()){
			//Using a Statement - beware of SQL injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt = conn.createStatement();	//We'll get a ResultSet object back
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				c1.add(new Cave(id,name,maxBears));
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException s) {
			s.printStackTrace();
		}
		
		return c1;
	}
	
	@Override
	public Cave getCaveById(int id) {
		return null;
	}

	@Override
	public String toString() {
		return "CaveDaoImp [getCaves()=" + getCaves() + "]";
	}
	
}
