package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static String filename = "connection.properties";

	@Override
	public List<Employee> getEmployees() {
		List<Employee> cl = new ArrayList<Employee>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			// Using a statement - beware SQL injection
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("EMPLOYEEID");
				String fname = rs.getString("FIRSTNAME");
				String lname = rs.getString("LASTNAME");
				cl.add(new Employee(id, fname, lname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cl;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return null;
	}

}
