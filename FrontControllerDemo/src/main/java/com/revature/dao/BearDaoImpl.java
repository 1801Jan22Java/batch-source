package com.revature.dao;

import java.io.IOException; 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao{

	
	@Override
	public List<Bear> getBears() {
		List<Bear> bears = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			bears = new ArrayList<Bear>();
			String sql = "SELECT * FROM BEAR";
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			int id, typeId, weight, caveId;
			String name;
			Date birthday;
			while(rs.next()) {
				id = rs.getInt(1);
				typeId = rs.getInt(2);
				name = rs.getString(3);
				birthday = rs.getDate(4);
				
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return bears;
	}

	@Override
	public Bear getBearByID(int id) {
		Bear barry = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BEAR WHERE BEAR_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			int bid = rs.getInt(1);
			int typeId = rs.getInt(2);
			int weight = rs.getInt(5); 
			int caveId = rs.getInt(6);
			String name = rs.getString(3);
			Date birthday = rs.getDate(4);
		
			barry = new Bear(bid, typeId, name, birthday, weight, caveId);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return barry;
	}

	@Override
	public void feedBear(int bearID, int beehive, int honeyAmt) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "call SP_FEED_BEAR(?, ?, ?)";
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
