package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee login(String username, String password) {

		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMAIL=? AND USERPASS=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				emp.setManager(isEmployeeManager(emp.getEmail()));
				
				return emp;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void register(String email, String password) {

		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "INSERT INTO ERS_EMPLOYEE VALUES(EMP_ID_SEQUENCE.NEXTVAL,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.executeQuery();
			System.out.println("Registering account");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isEmailRegistered(String email) {

		Connection connection;
		boolean isTaken = false;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMAIL=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				isTaken = true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			isTaken = true;
		} catch (SQLException e) {
			e.printStackTrace();
			isTaken = true;
		}
		

		return isTaken;
	}

	@Override
	public boolean isEmployeeManager(String email) {
		Connection connection;
		boolean isManager = false;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_MANAGER "+ 
					"INNER JOIN ERS_EMPLOYEE " + 
					"ON ERS_MANAGER.EMP_ID=ERS_EMPLOYEE.EMP_ID " + 
					"WHERE ERS_EMPLOYEE.EMAIL = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				isManager = true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			isManager = true;
		} catch (SQLException e) {
			e.printStackTrace();
			isManager = true;
		}
		

		return isManager;
	}

	@Override
	public List<Employee> getEmployees() {
		Connection connection;
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_EMPLOYEE";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return employees;
	}

	@Override
	public Employee getEmployee(String email) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMAIL=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMP_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return null;
	}

	@Override
	public void changeEmail(String oldEmail, String newEmail) {
		
		Connection connection;
		
		try {
			connection = ConnectionUtil.connectToDatabase(ConnectionUtil.PROPERTIES_FILE);
			
			String sql = "UPDATE ERS_EMPLOYEE SET EMAIL=? WHERE EMAIL=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newEmail);
			statement.setString(2, oldEmail);
			
			statement.executeQuery();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
