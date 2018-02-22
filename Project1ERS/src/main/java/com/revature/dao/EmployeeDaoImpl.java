package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

import com.revature.beans.*;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	private static final int TEMP_PASSWORD_LENGTH = 10;
	
	@Override
	public Employee login(String email, String password) {
		PreparedStatement pstmt = null;
		Employee thisEmployee = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT employee_id, firstname, lastname, email, job_title, creation_date " +
						 "FROM employee " +
						 "WHERE email = ? AND password = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the password matches the username, so save all info to object
			if(rs.next()){
				int employeeId = rs.getInt("employee_id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String jobTitle = rs.getString("job_title");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				thisEmployee = new Employee(employeeId, firstname, lastname, email, jobTitle, creationDate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return thisEmployee;
	}
	
	@Override
	public Employee getEmployee (int employeeId) {
		PreparedStatement pstmt = null;
		Employee thisEmployee = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT firstname, lastname, email, job_title, creation_date " +
						 "FROM employee " +
						 "WHERE employee_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the password matches the username, so save all info to object
			if(rs.next()){
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String jobTitle = rs.getString("job_title");
				LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
				thisEmployee = new Employee(employeeId, firstname, lastname, email, jobTitle, creationDate);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return thisEmployee;
	}
	
	
	
	@Override
	public boolean isManager(Employee thisManager) {
		PreparedStatement pstmt = null;
		boolean isManager = false;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT reports_to FROM employee WHERE reports_to = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, thisManager.getEmployeeId());
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then this employee's id is listed in the reports_to column and is a manager
			// IF rs.next() returns false, then this employee's id is NOT listed in the reports_to column and is NOT a manager
			isManager = rs.next();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isManager;
	}
	
	@Override
	public boolean getAllEmployees(Employee thisManager) {
		EmployeeDao emd = new EmployeeDaoImpl();
		thisManager.getEmployees().clear();
		PreparedStatement pstmt = null;
		boolean success = false;
		if (emd.isManager(thisManager)) {
			try(Connection con = ConnectionUtil.getConnectionFromFile()){
				String sql = "SELECT emp.employee_id, emp.firstname, emp.lastname, emp.email, emp.job_title, emp.creation_date, " + 
						"man.employee_id AS man_employee_id, man.firstname AS man_firstname, man.lastname AS man_lastname, " +
						"man.email AS man_email, man.job_title AS man_job_title, man.creation_date AS man_creation_date " +
						"FROM employee emp " +
						"LEFT JOIN employee man ON man.employee_id = emp.reports_to " +
						"ORDER BY emp.lastname ASC";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					success = true;
					int employeeId = rs.getInt("employee_id");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String email = rs.getString("email");
					String jobTitle = rs.getString("job_title");
					LocalDate creationDate = rs.getDate("creation_date").toLocalDate();
					// If the request has not been finalized by a manager set the manager to null
					Employee empManager = null;
					if (rs.getInt("man_employee_id") > 0) {
						int manEmployeeId = rs.getInt("man_employee_id");
						String manFirstname = rs.getString("man_firstname");
						String manLastname = rs.getString("man_lastname");
						String manEmail = rs.getString("man_email");
						String manJobTitle = rs.getString("man_job_title");
						LocalDate manCreationDate = rs.getDate("man_creation_date").toLocalDate();
						empManager = new Employee(manEmployeeId, manFirstname, manLastname, manEmail, manJobTitle, manCreationDate);
					}
					
					thisManager.getEmployees().add(new Employee(employeeId, firstname, lastname, email, jobTitle, creationDate, empManager));
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return success;
	}

	@Override
	public boolean updateProfile(String firstname, String lastname, String email, String password,
			String jobTitle, Employee thisEmployee) {
		EmployeeDao emd = new EmployeeDaoImpl();
		CallableStatement cs = null;
		boolean success = false;
		Employee testEmployee = null;
		testEmployee = emd.getEmployee(thisEmployee.getEmployeeId());
		if (testEmployee != null) {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();
				String sql = "{ call update_employee(?, ?, ?, ?, ?, ?, ?) }";
				cs = con.prepareCall(sql);
				cs.setInt(1, thisEmployee.getEmployeeId());
				cs.setString(2, firstname);
				cs.setString(3, lastname);
				cs.setString(4, email);
				cs.setString(5, password);
				cs.setString(6, jobTitle);
				cs.registerOutParameter(7, Types.INTEGER);
				// Returns 1 if there is an OUT parameter, and 0 for no OUT parameter
				cs.executeUpdate();
				int response =  cs.getInt(7);
				if (response > 0) {
					success = true;
					thisEmployee.setFirstname(firstname);
					thisEmployee.setLastname(lastname);
					thisEmployee.setEmail(email);
					thisEmployee.setJobTitle(jobTitle);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return success;
	}
	
	@Override
	public boolean addEmployee(String firstname, String lastname, String email, String jobTitle, Employee thisManager) {
		CallableStatement cs = null;
		boolean success = false;
		/* ****************************************************************************************** */
		/* Random Password Generator from https://www.geeksforgeeks.org/generating-password-otp-java/ */
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_chars + Small_chars + numbers + symbols;
        Random rndm_method = new Random();
        char[] passwordChars = new char[TEMP_PASSWORD_LENGTH];
        for (int i = 0; i < TEMP_PASSWORD_LENGTH; i++) {
        	passwordChars[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        /* ****************************************************************************************** */
        String password = new String(passwordChars);
        
        try{
        	Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "{ call add_employee(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
			cs = con.prepareCall(sql);
			cs.setString(1, firstname);
			cs.setString(2, lastname);
			cs.setString(3, email);
			cs.setString(4, password);
			cs.setInt(5, thisManager.getEmployeeId());
			cs.setString(6, jobTitle);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.DATE);
			cs.registerOutParameter(9, Types.INTEGER);
			
			// Returns 1 if there is an OUT parameter, and 0 for no OUT parameter
			cs.executeUpdate();
			int response =  cs.getInt(9);
			if (response > 0) {
				success = true;
				int employeeId = cs.getInt(7);
				LocalDate creationDate = cs.getDate(8).toLocalDate();
				
				int manEmployeeId = thisManager.getEmployeeId();
				String manFirstname = thisManager.getFirstname();
				String manLastname = thisManager.getLastname();
				String manEmail = thisManager.getEmail();
				String manJobTitle = thisManager.getJobTitle();
				LocalDate manCreationDate = thisManager.getCreationDate();
				
				Employee empManager = new Employee(manEmployeeId, manFirstname, manLastname, manEmail, manJobTitle, manCreationDate);
				Employee newEmployee = new Employee(employeeId, firstname, lastname, email, jobTitle, creationDate, empManager);
				thisManager.getEmployees().add(newEmployee);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean isAvailable(String email) {
		PreparedStatement pstmt = null;
		boolean isAvailable = true;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT employee_id FROM employee WHERE email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			ResultSet rs = pstmt.executeQuery();
			// If rs.next() returns true, then the username is taken, so set isUnique to false
			// IF rs.next() returns false, then the username is available, so set isUnique to true
			isAvailable = !rs.next();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isAvailable;
	}

}
