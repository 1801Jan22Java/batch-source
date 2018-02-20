package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
						.getReimbursementRequestsByEmplId(id);
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
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getEmployeeByUsername(empl.getUserName());
	}

	@Override
	public List<Employee> getEmployees() {
		PreparedStatement stmt = null;
		ReimbursementRequestDAO rr = new ReimbursementRequestPLSQLImpl();
		List<Employee> empls = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int emplId = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String title = rs.getString("EMPL_TYPE");
				String email = rs.getString("EMAIL");
				List<ReimbursementRequest> rrs = rr
						.getReimbursementRequestsByEmplId(emplId);
				EmployeeTitle t;
				if (title.equals("MANAGER")) {
					t = EmployeeTitle.MANAGER;
				} else {
					t = EmployeeTitle.EMPLOYEE;
				}
				Employee empl = new Employee(emplId, firstName, lastName,
						username, password, t, email, rrs);
				empls.add(empl);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return empls;
	}

	@Override
	public Employee updateEmployee(Employee empl) {
		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, PASSWORD = ?, EMAIL = ? "
					+ "WHERE EMPL_ID = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, empl.getFirstName());
			stmt.setString(2, empl.getLastName());
			stmt.setString(3, empl.getPassword());
			stmt.setString(4, empl.getEmail());
			stmt.setInt(5, empl.getId());

			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getEmployeeById(empl.getId());
	}

	@Override
	public void deleteEmployee(Employee empl) {
		PreparedStatement stmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMPL_ID = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, empl.getId());
			stmt.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Employee signIn(String username, String password) {
		PreparedStatement stmt = null;
		Employee empl = null;
		ReimbursementRequestDAO rr = new ReimbursementRequestPLSQLImpl();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				username = rs.getString("USERNAME");
				password = rs.getString("PASSWORD");
				String title = rs.getString("EMPL_TYPE");
				String email = rs.getString("EMAIL");
				List<ReimbursementRequest> rrs = rr
						.getReimbursementRequestsByEmplId(id);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		PreparedStatement stmt = null;
		ReimbursementRequestDAO rr = new ReimbursementRequestPLSQLImpl();
		Employee empl = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String title = rs.getString("EMPL_TYPE");
				String email = rs.getString("EMAIL");
				List<ReimbursementRequest> rrs = rr
						.getReimbursementRequestsByEmplId(id);
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

}
