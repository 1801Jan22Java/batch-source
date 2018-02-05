package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public List<Department> getDepartments() {
		
		List<Department> departments = new ArrayList<Department>();
		
		try {
			String sql = "SELECT * FROM DEPARTMENT";
			
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				
				departments.add(new Department(id, name));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public int getAverageSalary(int depID) {

		try {

			String sql = "{call GET_DEP_AVG_SAL(?, ?)}";
			CallableStatement statement = ConnectionUtil.connection.prepareCall(sql);
			statement.setInt(1, depID);
			int average = 0;
			statement.setInt(2, average);
			statement.execute();

			System.out.println("Average: " + average);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public void giveRaise(int depID) {
		try {

			String sql = "{call SP_GIVE_RAISE(?,?,?)}";
			CallableStatement statement = ConnectionUtil.connection.prepareCall(sql);
			statement.setInt(1, depID);
			statement.setInt(2, 0);
			statement.setInt(3, 0);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to give raise!");
			return;
		}
		
		System.out.println("Raise given!");
	}

}
