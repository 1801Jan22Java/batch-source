package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import com.revature.util.ConnectionUtil;


public class DepartmentDAoImpl implements DepartmentDAO {

	
	private final String filename = "connection.properties";
	
	@Override
	public Map<String, Double> getAverageSalary() {
		Map<String, Double> deps = new TreeMap<>();
		PreparedStatement stmnt = null;
		String name;
		Double avg;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT DEPARTMENT_NAME, AVG(SALARY) AS AVERAGE_SALARY "
					+ "FROM EMPLOYEE INNER JOIN DEPARTMENT  "
					+ "ON EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.DEPARTMENT_ID "
					+ "GROUP BY DEPARTMENT_NAME";
			
			stmnt = con.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			
			while (rs.next()) {
				name = rs.getString("DEPARTMENT_NAME");
				avg = rs.getDouble("AVERAGE_SALARY");
				deps.put(name, avg);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return deps;

	}

	@Override
	public void giveRaiseToDepartmentById(int depId) {
		
		CallableStatement stmnt = null;
		Integer avg = 2;
		Integer exists = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "{CALL SP_GIVE_RAISE(?, ?, ?)}";
			stmnt = con.prepareCall(sql);
			stmnt.setInt(1, depId);
			stmnt.setInt(2, avg);
			stmnt.setInt(3, exists);
			stmnt.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void giveRaiseToDepartmentById(int depId, int perIncr) {
		
		CallableStatement stmnt = null;
		Integer avg = 2;
		Integer exists = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "{CALL SP_GIVE_RAISE_PERCENT_PROVIDED(?, ?, ?, ?)}";
			stmnt = con.prepareCall(sql);
			stmnt.setInt(1, depId);
			stmnt.setInt(2, perIncr);
			stmnt.setInt(3, avg);
			stmnt.setInt(4, exists);
			stmnt.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
