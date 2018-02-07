package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoSQL implements DepartmentDao {

	@Override
	public List<Department> getDepartments() {
		List<Department> resultDepartments = new ArrayList<Department>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			Department result;
			String sql = "SELECT * FROM DEPARTMENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int depId = rs.getInt("DEPARTMENT_ID");
				String name = rs.getString("DEPARTMENT_NAME");
				result = new Department(depId,name);
				resultDepartments.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultDepartments;
	}

	@Override
	public void getNameAvg(int dep_id) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			con.setAutoCommit(false);
			String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setInt(1, dep_id);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				String depName = rs.getString("DEPARTMENT_NAME");
				System.out.println(depName);
			}
			String sql2 = "SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, dep_id);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				 double avg = rs2.getDouble("AVG(SALARY)");
				 System.out.println(avg);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
