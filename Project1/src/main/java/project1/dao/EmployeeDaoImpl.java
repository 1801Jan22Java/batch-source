package project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project1.util.ConnectionUtil;
import project1.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public Employee viewInfromationById(int Id) {
		Employee emp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int isManager = rs.getInt("IS_MANAGER");
				boolean b;
				if (isManager == 1) {
					b = true;
				} else {
					b = false;
				}
				// put the info into an employee object
				emp = new Employee(i, username, password, fName, lName, b);
			}
			con.close();

		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return emp;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> emp = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				Integer isManager = rs.getInt("IS_MANAGER");
				boolean b;
				if (isManager == 1) {
					b = true;
				} else {
					b = false;
				}
				emp.add(new Employee(i, username, password, fName, lName, b));
			}
			con.close();

		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return emp;
	}

	public void updateEmployeeFirstName(String fName, int empId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fName);
			pstmt.setInt(2, empId);
			pstmt.executeQuery();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void updateEmployeeLastName(String lName, int empId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE EMPLOYEE SET LASTNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lName);
			pstmt.setInt(2, empId);
			pstmt.executeQuery();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void updateEmployeeUsername(String username, int empId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE EMPLOYEE SET USERNAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, empId);
			pstmt.executeQuery();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void updateEmployeePassword(String password, int empId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE EMPLOYEE SET PASSWORD = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, empId);
			pstmt.executeQuery();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public Employee login(String username, String password) {
		Employee emp = null;
		if (username == null || password == null) {
			return emp;
		}
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRSTNAME");
				String lName = rs.getString("LASTNAME");
				String eUsername = rs.getString("USERNAME");
				String ePassword = rs.getString("PASSWORD");
				Integer isManager = rs.getInt("IS_MANAGER");
				boolean b;
				if (isManager == 1) {
					b = true;
				} else {
					b = false;
				}
				emp = new Employee(i, eUsername, ePassword, fName, lName, b);
			}
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}

		return emp;
	}

}
