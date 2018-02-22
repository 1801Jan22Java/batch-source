package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public static final String filename = "C:\\Users\\Leonard\\GitRepos\\batch-source\\Project1_Reimbursment\\connection.properties";

	// I know it's a horrible practice, but
	// a FileNotFoundException was giving me grief
	// and copy/pasting the file to (literally) every folder in the project
	// didn't solve a thing. So, I'm using an absolute path. 
	// This feels like the programming version of seppuku 
	public void addEmployee(Employee emp) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO EMPLOYEE (Email, Pword, IsManager, FirstName, LastName, "
					+ "Phone, JobTitle, ReportsTo, Active) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			int manager = 0;
			if (emp.isManager())
				manager = 1;
			else
				manager = 0;
			ps.setString(1, emp.getEmail());
			ps.setString(2, emp.getPassword());
			ps.setInt(3, manager);
			ps.setString(4, emp.getFirstName());
			ps.setString(5, emp.getLastName());
			ps.setString(6, emp.getPhone());
			ps.setString(7, emp.getJobTitle());
			ps.setInt(8, emp.getReportsTo());
			ps.setInt(9, emp.getActive());
			ps.executeUpdate();
			ps.close();

			String sql0 = "SELECT EmpID FROM EMPLOYEE WHERE EMAIL = ?";
			PreparedStatement ps0 = con.prepareStatement(sql0);
			ps0.setString(1, emp.getEmail());
			ResultSet rs = ps0.executeQuery();
			if (rs.next()) {
				if (emp.isManager()) {
					emp = new Manager(rs.getInt("EmpID"), emp.getFirstName(), emp.getLastName(), emp.getEmail(),
							emp.getPassword(), emp.getReportsTo(), emp.getPhone(), emp.getJobTitle(), true,
							emp.getActive());
				} else {
					emp = new Employee(rs.getInt("EmpID"), emp.getFirstName(), emp.getLastName(), emp.getEmail(),
							emp.getPassword(), emp.getReportsTo(), emp.getPhone(), emp.getJobTitle(), false,
							emp.getActive());
				}
			}

			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateEmployee(Employee emp) {
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONE = ?, JOBTITLE = ? WHERE EmpID = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getJobTitle());
			ps.setInt(6, emp.getEmployeeID());
			ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees;
		try {
			employees = new ArrayList<Employee>();
			int EmployeeID;
			String FirstName;
			String LastName;
			String email;
			String password;
			int reportsTo;
			String phone;
			String jobTitle;
			boolean isManager;
			int active;
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String str = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = con.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeID = rs.getInt("EMPID");
				FirstName = rs.getString("FirstName");
				LastName = rs.getString("LastName");
				email = rs.getString("Email");
				password = rs.getString("Pword");
				reportsTo = rs.getInt("ReportsTo");
				phone = rs.getString("Phone");
				jobTitle = rs.getString("JobTitle");
				isManager = (rs.getInt("IsManager") > 0);
				active = rs.getInt("Active");

				if (isManager) {

					employees.add(new Manager(EmployeeID, FirstName, LastName, email, password, reportsTo, phone,
							jobTitle, isManager, active));
				} else {

					employees.add(new Employee(EmployeeID, FirstName, LastName, email, password, reportsTo, phone,
							jobTitle, isManager, active));
				}
			}

			con.close();
			return employees;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Employee> getManagers() {
		ArrayList<Employee> employees = getAllEmployees();
		ArrayList<Employee> managers = new ArrayList<Employee>();
		for (Employee i : employees) {
			if (i.isManager()) {
				managers.add(i);
			}
		}
		return managers;
	}

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = getAllEmployees();
		ArrayList<Employee> drones = new ArrayList<Employee>();
		for (Employee i : employees) {
			if (!i.isManager()) {
				drones.add(i);
			}
		}
		return drones;
	}

	public Employee getEmployeeById(int id) {
		try {
			int EmployeeID;
			String FirstName;
			String LastName;
			String email;
			String password;
			int reportsTo;
			String phone;
			String jobTitle;
			boolean isManager;
			int active;
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String str = "SELECT * FROM EMPLOYEE WHERE EMPID = ?";
			PreparedStatement ps = con.prepareStatement(str);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				EmployeeID = rs.getInt("EMPID");
				FirstName = rs.getString("FIRSTNAME");
				LastName = rs.getString("LASTNAME");
				email = rs.getString("EMAIL");
				password = rs.getString("PWORD");
				reportsTo = rs.getInt("REPORTSTO");
				phone = rs.getString("PHONE");
				jobTitle = rs.getString("JOBTITLE");
				isManager = (rs.getInt("ISMANAGER") > 0);
				active = rs.getInt("ACTIVE");

				if (isManager) {
					con.close();
					return new Manager(EmployeeID, FirstName, LastName, email, password, reportsTo, phone, jobTitle,
							isManager, active);
				} else {
					con.close();
					return new Employee(EmployeeID, FirstName, LastName, email, password, reportsTo, phone, jobTitle,
							isManager, active);
				}
			} else {
				con.close();
				return null;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
