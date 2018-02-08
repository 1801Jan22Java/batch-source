package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao
{
	private static String filename = "connection.properties";

	@Override
	public List<Department> getAllDepartments() {
		List<Department> dl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM DEPARTMENT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("DEPARTMENT_ID");
				String name = rs.getString("DEPARTMENT_NAME");
				dl.add(new Department(id,name));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return dl;
	}

	@Override
	public Department getDepartmentById(int id) {
		PreparedStatement pstmt = null;
		Department department = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("DEPARTMENT_NAME");
				department = new Department(id,name);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return department;
	}
	
}
