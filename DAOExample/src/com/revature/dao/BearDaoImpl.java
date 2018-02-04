package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao {
	
	private static String filename = "connection.properties";
	
	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<>();
		CaveDaoImpl cdi = new CaveDaoImpl();
		BearTypeDaoImpl btdi = new BearTypeDaoImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM BEAR";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("BEAR_ID");
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bl.add(new Bear(id,name,cave,bt,weight,birthdate));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bl;
	}

	@Override
	public Bear getBearById(int id) {
		PreparedStatement pstmt = null;
		CaveDaoImpl cdi = new CaveDaoImpl();
		BearTypeDaoImpl btdi = new BearTypeDaoImpl();
		Bear bear = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bear = new Bear(id,name,cave,bt,weight,birthdate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bear;
	}

	@Override
	public void createBear(Bear bear) {
		
		PreparedStatement pstmt = null;

		int bearsCreated = 0;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO BEAR (BEAR_TYPE_ID, BEAR_NAME, BEAR_BIRTHDATE, BEAR_WEIGHT, CAVE_ID)"
					+ "VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bear.getBearType().getId());
			pstmt.setString(2, bear.getName());
			pstmt.setDate(3, new Date(bear.getBirthdate().getTime()));
			pstmt.setInt(4, bear.getWeight());
			pstmt.setInt(5, bear.getCave().getId());
			
			bearsCreated = pstmt.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void feedBear(int bearId, int beehiveId, int honeyAmt) {
		CallableStatement cblmt = null;
		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql= "{CALL SP_FEED_BEAR(?, ?, ?)}";
			cblmt = con.prepareCall(sql);
			cblmt.setInt(1, bearId);
			cblmt.setInt(2, beehiveId);
			cblmt.setInt(3, honeyAmt);
			//if out stored procedure had out parameters
			
			cblmt.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}