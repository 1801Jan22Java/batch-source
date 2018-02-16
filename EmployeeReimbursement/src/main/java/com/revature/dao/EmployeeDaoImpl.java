package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public boolean createEmployee(String firstName, String lastName, String email, String password) {
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE "
					+ "(FIRST_NAME,LAST_NAME,EMAIL,PASS)"
					+ " VALUES (?,?,?,?);");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);	//1 - NOT SUBMITTED
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public Employee readEmployee(String email) {
		
		Employee emp = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL=?");
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			//Email exists
			if(rs.next()) {
				if(email.equals(rs.getString("email"))){
					emp = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
										rs.getString("LAST_NAME"), rs.getString("EMAIL"));
					return emp;
				}
				else {
					throw new InvalidPasswordException("Invalid credentials!");
				}
			}
			
			//Email does not exist
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return emp;
	}
	
	public Employee readEmployee(int employeeID) {
		
		Employee emp = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?");
			pstmt.setInt(1,employeeID);
			rs = pstmt.executeQuery();
			
			emp = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), 
					rs.getString("LAST_NAME"), rs.getString("EMAIL"));
			
			return emp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

}
