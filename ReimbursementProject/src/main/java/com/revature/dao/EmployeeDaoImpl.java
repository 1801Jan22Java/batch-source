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

public class EmployeeDaoImpl implements EmployeeDao {

	// TODO: Add ORDER BY if displaying in an odd order on page
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();

		PreparedStatement pstmt = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String email = rs.getString("EMAIL");
				String password = rs.getString("E_PASSWORD");
				employeeList.add(new Employee(employeeId, firstName, lastName, address, city, state,
						phoneNumber, email, password));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		PreparedStatement pstmt = null;
		Employee employee = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String email = rs.getString("EMAIL");
				String password = rs.getString("E_PASSWORD");
				employee = new Employee(employeeId, firstName, lastName, address, city, state,
						phoneNumber, email, password);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employee;
	}

	// TODO: To use these methods, must find out how to save employeeId from the logged in Employee
	@Override
	public void updateAddress(int employeeId, String address) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET ADDRESS = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateCity(int employeeId, String city) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET CITY = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, city);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateState(int employeeId, String state) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET STATE = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, state);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updatePhoneNumber(int employeeId, String phoneNumber) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET PHONE_NUMBER = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNumber);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateEmail(int employeeId, String email) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET EMAIL = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void updatePassword(int employeeId, String password) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "UPDATE EMPLOYEE SET E_PASSWORD = '?' WHERE EMPLOYEE_ID = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, employeeId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
