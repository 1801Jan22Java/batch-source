package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeTitle;
import com.revature.beans.ReimbursementRequest;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoPLSQLImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeById(int id) {
		PreparedStatement stmt = null;
		ReimbursementRequestDAO rr = new ReimbursementRequestPLSQLImpl();
		Employee empl = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPL_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String title = rs.getString("EMPL_TYPE");
				String email = rs.getString("EMAIL");
				List<ReimbursementRequest> rrs = rr
						.getProcessedReimbursementRequests(id);
				EmployeeTitle t;
				if (title.equals("MANAGER")) {
					t = EmployeeTitle.MANAGER;
				} else {
					t = EmployeeTitle.EMPLOYEE;
				}
				empl = new Employee(id, firstName, lastName, username, password,
						t, email, rrs);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return empl;
	}

	@Override
	public Employee createEmployee(Employee empl) {
		PreparedStatement stmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO EMPLOYEE "
					+ "(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL, EMPL_TYPE) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, empl.getFirstName());
			stmt.setString(2, empl.getLastName());
			stmt.setString(3, empl.getUserName());
			stmt.setString(4, empl.getPassword());
			stmt.setString(5, empl.getEmail());
			stmt.setString(6, empl.getTitle().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee empl) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee signIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
