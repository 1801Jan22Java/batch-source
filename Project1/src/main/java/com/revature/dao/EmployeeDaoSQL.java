package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoSQL implements EmployeeDao {

	// get a list of all the employees in the database
	public List<Employee> getEmployees() {
		
		// create a list object to store the employees,
		//if the list is empty then nothing was in the DB
		List<Employee> listEmployee = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			
			// result is a placeholder variable for creating employees to insert into the list
			Employee result;
			String sql = "SELECT * FROM Employee";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeInfoId = rs.getInt("EMPLOYEE_INFO_ID");
				result = new Employee(employeeId,username,password,employeeInfoId);
				listEmployee.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listEmployee;

	}

	// get an employee from the database using the Id 
	// to be used predominately by the application no the user
	public Employee getEmployeeByID(int requestedEmployeeId) {
		
		// if employeeResult is null then you could not find the requested Id
		// not for this function to decide what to do with that information
		Employee employeeResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, requestedEmployeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int employeeInfoId = rs.getInt("EMPLOYEE_INFO_ID");
				employeeResult = new Employee(employeeId,username,password,employeeInfoId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeResult;
	}

	// get an employee based on the login credentials
	// to be used when validating login
	public Employee getEmployeeByCredentials(String username, String password) {
		
		// if employeeResult is null then you could not find the requested Id
		// not for this function to decide what to do with that information
		Employee employeeResult = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT * FROM EMPLOYEE WHERE (USERNAME = ?) AND (PASSWORD = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int employeeInfoId = rs.getInt("EMPLOYEE_INFO_ID");
				employeeResult = new Employee(employeeId,username,password,employeeInfoId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeResult;
	}

	// used to add an employee to the DB using the stored procedure called add_employee returns the Id of the employee added
	public int addEmployee(String username, String password, String email, String firstname, String lastname, String address) {
		
		// employeeId should never be negative, so if the returned integer
		// is -1, something went wrong inserting the employee
		int employeeId = -1;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			con.setAutoCommit(false);
			String sql = "{call ADD_EMPLOYEE(?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, email);
			cs.setString(4, firstname);
			cs.setString(5, lastname);
			cs.setString(6, address);
			cs.registerOutParameter(7, java.sql.Types.INTEGER);
			cs.execute();
			employeeId = cs.getInt(7);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeId;
	}

}
