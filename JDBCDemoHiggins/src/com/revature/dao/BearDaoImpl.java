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
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BEAR";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("BEAR_ID");
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bl.add(new Bear(id, name, cave, bt, weight, birthdate));
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
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BEAR WHERE BEAR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("BEAR_NAME");
				int weight = rs.getInt("BEAR_WEIGHT");
				int caveId = rs.getInt("CAVE_ID");
				Cave cave = cdi.getCaveById(caveId);
				int typeId = rs.getInt("BEAR_TYPE_ID");
				BearType bt = btdi.getBearTypeById(typeId);
				Date birthdate = rs.getDate("BEAR_BIRTHDATE");
				bear = new Bear(id, name, cave, bt, weight, birthdate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bear;
	}

	public void insertBear(int bearTypeId, String bearName, String bearBirthdate, int bearWeight, int caveId) {
		PreparedStatement pstmt = null;
		CaveDaoImpl cdi = new CaveDaoImpl();
		BearTypeDaoImpl btdi = new BearTypeDaoImpl();
		Bear bear = null;

		String[] bdaystring = bearBirthdate.split("/");
		int year = Integer.parseInt(bdaystring[0]);
		int month = Integer.parseInt(bdaystring[1]);
		int day = Integer.parseInt(bdaystring[2]);
		Date bday = new Date(year, month, day);

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO BEAR (BEAR_TYPE_ID,BEAR_NAME,BEAR_BIRTHDATE,BEAR_WEIGHT,CAVE_ID)"
					+ "VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bearTypeId);
			pstmt.setString(2, bearName);
			pstmt.setDate(3, bday);
			pstmt.setInt(4, bearWeight);
			pstmt.setInt(5, caveId);
			pstmt.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public int feedBear(int bearId, int hiveId, int amt) {
		int amtFed = 0;
		CallableStatement cs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "{call SP_FEED_BEAR(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, bearId);
			cs.setInt(2, hiveId);
			cs.setInt(3, amt);
			// if our stored procedure had out parameters,
			// we would us cs.registerOutParameter(4,java.sql.Types.INTEGER) or similar
			cs.execute();
			amtFed = amt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amtFed;
	}
}