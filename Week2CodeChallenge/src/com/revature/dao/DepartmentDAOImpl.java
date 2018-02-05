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
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO{
	
	private static String filename ="connection.properties";

	public List<Department> getAllDepartments() {
		List<Department> c1 = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DEPARTMENT");
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int id = results.getInt("DEPARTMENT_ID");
				String name = results.getString("DEPARTMENT_NAME");

				c1.add(new Department(id, name));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c1;
	}

	public Department getDepartmentById(int id) {

		return null;
	}

	@Override
	public List<Employee> giveSalaryRaise(int id) {
		List<Employee> gotRaise = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			CallableStatement cstmt = con.prepareCall("{call SP_GIVE_RAISE(?)}");
			cstmt.setInt(1, id);
			cstmt.execute();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPARTMENT_ID = ?");
			pstmt.setInt(1, id);
			ResultSet results = pstmt.executeQuery();
			while(results.next()) {
				int emp_id = results.getInt("EMPLOYEE_ID");
				String firstname = results.getString("EMP_FIRSTNAME");
				String lastname = results.getString("EMP_LASTNAME");
				double salary = results.getDouble("SALARY");
				String email = results.getString("EMP_EMAIL");
				gotRaise.add(new Employee(emp_id, firstname, lastname, email, salary, id));
			}
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return gotRaise;
	}
}
