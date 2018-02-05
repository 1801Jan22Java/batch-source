package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoSQL implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> resultEmployees = new ArrayList<Employee>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			Employee result;
			String sql = "SELECT * FROM Employee";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int emp_id = rs.getInt("EMPLOYEE_ID");
				String fname= rs.getString("EMP_FIRSTNAME");
				String lname= rs.getString("EMP_LASTNAME");
				int dep_id= rs.getInt("DEPARTMENT_ID");
				double salary= rs.getDouble("SALARY");
				String email = rs.getString("EMAIL");
				
				result = new Employee(emp_id,fname,lname,dep_id,salary,email);
				resultEmployees.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultEmployees;
	}

}
