package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	private static String filename = "connection.properties";

	public void departmentSalaryAverage() {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);		
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEE WHERE DEPARTMENT_ID = ?";
			String sql2 = "SELECT DEPARTMENT_NAME FROM DEPARTMENT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 5);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<String> avSal = new ArrayList<String>();
			while (rs.next())
			{
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	/*Write a prepared statement which prints each department's name and average salary to the console
	in STS. */
	
}
