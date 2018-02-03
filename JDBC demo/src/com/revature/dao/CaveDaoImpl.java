/**
 * 
 */
package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

/**
 * @author Okanu's PC
 *
 */
public class CaveDaoImpl implements CaveDao {

	private static String filename = "connection.properties";
	
	public List<Cave> getCaves() {
		List<Cave> cl = new ArrayList<Cave>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// Using a statement - beware SQL injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				cl.add(new Cave(id, name, maxBears));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cl;
	}
	
	public Cave getCaveById(int id) {
		return null;
	}
	
}
