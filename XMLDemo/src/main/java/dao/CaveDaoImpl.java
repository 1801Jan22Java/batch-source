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

public class CaveDaoImpl implements CaveDao{

	private static String filename = "connection.properties";
	
	@Override
	public List<Cave> getCaves() {
		List<Cave> cl = new ArrayList<Cave>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			// using a statement - beware SQL injection
			String sql = "SELECT * FROM CAVE";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("Cave_Name");
				int maxBears = rs.getInt("MAX_BEARS");
				cl.add(new Cave(id, name, maxBears));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return cl;
	}

	@Override
	public Cave getCaveByID(int id) {
		Cave lechugilla = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM CAVE WHERE ID = ?");
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			int cid = rs.getInt("CAVE_ID");
			String cname = rs.getString("CAVE_NAME");
			int max = rs.getInt("MAX_BEARS");
			lechugilla = new Cave (cid, cname, max);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return lechugilla;
	}
	
	

}
