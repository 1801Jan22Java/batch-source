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

public class CaveDAOImpl implements CaveDAO{
	
	private static String filename ="connection.properties";

	public List<Cave> getCaves() {
		List<Cave> c1 = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			// Using a Statement - Beware SQL injection
			String str = "SELECT * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(str);
			while(results.next()) {
				int id = results.getInt("CAVE_ID");
				String name = results.getString("CAVE_NAME");
				int maxBears = results.getInt("MAX_BEARS");
				c1.add(new Cave(id, name, maxBears));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c1;
	}

	public Cave getCaveById(int id) {
		Cave c1 = new Cave();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CAVE WHERE CAVE_ID = ?");
			pstmt.setInt(1, id);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				String name = results.getString("CAVE_NAME");
				int maxBears = results.getInt("MAX_BEARS");
				c1.setId(id);
				c1.setName(name);
				c1.setMaxBears(maxBears);
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return c1;
	}
	
}
