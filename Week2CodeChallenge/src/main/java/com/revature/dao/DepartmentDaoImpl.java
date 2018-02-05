package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static String filename = "connection.properties";

	@Override
	public ArrayList<Department> getAverages() {
		ArrayList<Department> departments = new ArrayList<>();
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT AVG(salary) AS salary,d.department_name " + 
					"FROM employee e INNER JOIN department d " + 
					"ON e.department_id = d.department_id " + 
					"GROUP BY d.department_name ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				double salary = rs.getInt("salary");
				String departmentName = rs.getString("department_name");
				departments.add(new Department(departmentName, salary));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return departments;
	}
	
	@Override
	public int getDeptIdByName(String deptName) {
		ArrayList<Department> departments = new ArrayList<>();
		PreparedStatement pstmt = null;
		int deptId = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT department_id " + 
					"FROM department " + 
					"WHERE department_name = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deptName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				deptId = rs.getInt("department_id");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return deptId;
	}

}
