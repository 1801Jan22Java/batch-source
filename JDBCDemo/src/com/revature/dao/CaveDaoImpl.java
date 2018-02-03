package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.Rdn;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDaoImpl implements CaveDao {
	
	private static String filename = "connection.properties";

	@Override
	public List<Cave> getCaves() {
		List<Cave> cList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			// using a statement - beware sql injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears= rs.getInt("MAX_BEARS");
				
				cList.add(new Cave(id, name, maxBears));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cList;
	}
	
	@Override
	public Cave getCaveById(int id) {
		return null;
	}

}
