package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee2;
import com.revature.util.ConnectionUtil;

public class Employee2DaoImpl implements Employee2Dao {
	private static String filename = "connection.properties";

	public Employee2 getEmployee2ById(int id) {
		PreparedStatement pstmt = null;
		Employee2 emp = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE2 WHERE EMPLOYEE_ID=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String fname = rs.getString("EMP_FIRSTNAME");
				String lname = rs.getString("EMP_LASTNAME");
				int dep_id = rs.getInt("DEPARTMENT_ID");
				int salary = rs.getInt("SALARY");
				String email = rs.getString("EMP_EMAIL");
				emp = new Employee2(id, fname, lname, dep_id, salary, email);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

}
