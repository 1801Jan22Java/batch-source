package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static String filename = "connection.properties";
	
	//Create an Employee Object
	public int createEmployee(int empID, String empFName, String empLName, String empEmail, String empAcc,
			String empPass, int isMan) {
		
			int empVal = 0;
			Connection con = null;
			try {
				con = ConnectionUtil.getConnectionFromFile(filename);
				String sql = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_FNAME, EMPLOYEE_LNAME, EMPLOYEE_EMAIL, "
						+ "EMPLOYEE_ACCOUNT, EMPLOYEE_PASSWORD, IS_MANAGER)"+
				" VALUES(EMP_NUM_SEQ.NEXTVAL,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,  empFName);
				pstmt.setString(2,  empLName);
				pstmt.setString(3,  empEmail);
				pstmt.setString(4,  empAcc);
				pstmt.setString(5,  empPass);
				pstmt.setInt(6, isMan);
				empVal = pstmt.executeUpdate();
			con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			return empVal;
	
	}

	//Finds an Employee by ID
	public Employee getEmpByID(int empID) {
		PreparedStatement pstmt = null;
		Employee employee = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int eID = rs.getInt("EMPLOYEE_ID");
				String empFName = rs.getString("EMPLOYEE_FNAME");
				String empLName = rs.getString("EMPLOYEE_LNAME");
				String empEmail = rs.getString("EMPLOYEE_EMAIL");
				String empAcc = rs.getString("EMPLOYEE_ACCOUNT");
				String empPassword = rs.getString("EMPLOYEE_PASSWORD");
				int isMan = rs.getInt("IS_MANAGER");
				employee = new Employee(eID, empFName, empLName, empEmail, empAcc, empPassword, isMan);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return employee;
		
	}

	//Modifies an Employee column based on the column name provided (e.g. password, lastname, etc.)
	public Employee modifyEmployeeField(String empfield, String fieldVal, Employee empUser) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE EMPLOYEE SET " + empfield + " = ?" + " WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fieldVal);
			pstmt.setInt(2, empUser.getEmployeeID());
			pstmt.executeUpdate();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return empUser;
	
	}

	//Grabs and returns all Employees
	public ArrayList<Employee> getAllEmployees() {
		Connection con = null;
		ArrayList<Employee> allEmps = new ArrayList<Employee>();
		try {
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int empID = rs.getInt("EMPLOYEE_ID");
				String empFName = rs.getString("EMPLOYEE_FNAME");
				String empLName = rs.getString("EMPLOYEE_LNAME");
				String empEmail = rs.getString("EMPLOYEE_EMAIL");
				String empAccount = rs.getString("EMPLOYEE_ACCOUNT");
				String empPassword = rs.getString("EMPLOYEE_PASSWORD");
				int isMan = rs.getInt("IS_MANAGER");
				allEmps.add(new Employee(empID, empFName, empLName, empEmail, empAccount, empPassword, isMan));
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return allEmps;
	}

	//Finds an Employee by Account Name
	public Employee getEmpByAcc(String empAcc) {
		PreparedStatement pstmt = null;
		Employee employee = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ACCOUNT = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empAcc);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int eID = rs.getInt("EMPLOYEE_ID");
				String empFName = rs.getString("EMPLOYEE_FNAME");
				String empLName = rs.getString("EMPLOYEE_LNAME");
				String empEmail = rs.getString("EMPLOYEE_EMAIL");
				String empA = rs.getString("EMPLOYEE_ACCOUNT");
				String empPassword = rs.getString("EMPLOYEE_PASSWORD");
				int isMan = rs.getInt("IS_MANAGER");
				employee = new Employee(eID, empFName, empLName, empEmail, empA, empPassword, isMan);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		return employee;
	}
	
	


}
