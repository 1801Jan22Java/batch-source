package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			String sql = "SELECT * FROM EMPLOYEE";
			
			PreparedStatement statement = ConnectionUtil.connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int depId = rs.getInt(4);
				int salary = rs.getInt(5);
				String email = rs.getString(6);
				
				//int id, String firstName, String lastName, int dep_id, int salary, String email
				employees.add(new Employee(id, firstName, lastName, depId, salary, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}
