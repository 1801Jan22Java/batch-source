package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class DepartmentOracle implements DepartmentDao{

	private String filename = "connection.properties";
	
	@Override
	public void printAvgSalary() {
		String sql = "SELECT DEPARTMENT_NAME,AVG(SALARY) AS \"AVG\" " + 
				"FROM EMPLOYEE,DEPARTMENT " + 
				"WHERE EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.DEPARTMENT_ID " + 
				"GROUP BY DEPARTMENT_NAME";
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				double sal = rs.getDouble("AVG");
				String name = rs.getString("DEPARTMENT_NAME");
				System.out.println("Department: "+ name + " Average Salary: " + sal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
