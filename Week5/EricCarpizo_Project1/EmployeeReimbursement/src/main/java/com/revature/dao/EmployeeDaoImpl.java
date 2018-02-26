package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

/**
 * @author Eric
 *
 */
public class EmployeeDaoImpl implements EmployeeDao
{
	//return all employees from the DB
	public List<Employee> getEmployees() 
	{
		List<Employee> employees = new ArrayList<Employee>();
		try
		{
			//create a connection to the DB
			Connection con = ConnectionUtil.getConnectionFromFile();
			//Create query
			String sql = "SELECT * FROM Employee";
			//do not need a prepared statement since we are receiving no input from the user.
			Statement statement = con.createStatement();
			//execute the query and save the results 
			ResultSet rs = statement.executeQuery(sql);
			//iterate through the results
			while (rs.next())
			{
				//saving the necessary info to variables responding to the data type
				int id = rs.getInt("Employee_Id");
				String first = rs.getString("Emp_FirstName");
				String last = rs.getString("Emp_LastName");
				String email = rs.getString("Emp_Email");
				String password = rs.getString("Emp_Password");
				int managerId = rs.getInt("Manager_Id");
				int isManager = rs.getInt("IsManager");
				//each employee may have multiple requests
				RequestDaoImpl rdl = new RequestDaoImpl();
				//grab all requests
				List<Request> requests = rdl.getRequests();
				//each request needs to be saved
				ArrayList<Request> thisRequests = new ArrayList<Request>();
				//find the requests pertaining to this employee
				for(Request r : requests)
					if(r.getEmployeeId() == id)
						thisRequests.add(r);
				//createa and add the employee to the list of all employees
				employees.add(new Employee(id, first, last, email, password, managerId, isManager, thisRequests));
			}
			//close the connection
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//return all employees
		return employees;
	}

	//return the employee by the employee's ID
	public Employee getEmployeeById(int id)
	{
		Employee employee = null;

		PreparedStatement pstmt = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Employee WHERE Employee_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String first = rs.getString("Emp_FirstName");
				String last = rs.getString("Emp_LastName");
				String email = rs.getString("Emp_Email");
				String password = rs.getString("Emp_Password");
				int managerId = rs.getInt("Manager_Id");
				int isManager = rs.getInt("IsManager");
				RequestDaoImpl rdl = new RequestDaoImpl();
				List<Request> requests = rdl.getRequests();
				ArrayList<Request> thisRequests = new ArrayList<Request>();
				for(Request r : requests)
					if(r.getEmployeeId() == id)
						thisRequests.add(r);
				employee = new Employee(id, first, last, email, password, managerId, isManager, thisRequests);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return employee;
	}

	//return the employee by the employee's email and password
	public Employee getEmployeeByUsernameAndPassword(String username, String password)
	{
		Employee employee = null;
		PreparedStatement pstmt = null;
		try
		{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM Employee WHERE Emp_Email = ? AND Emp_Password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("Employee_Id");
				String first = rs.getString("Emp_FirstName");
				String last = rs.getString("Emp_LastName");
				int managerId = rs.getInt("Manager_Id");
				int isManager = rs.getInt("IsManager");
				RequestDaoImpl rdl = new RequestDaoImpl();
				List<Request> requests = rdl.getRequests();
				ArrayList<Request> thisRequests = new ArrayList<Request>();
				for(Request r : requests)
					if(r.getEmployeeId() == id)
						thisRequests.add(r);
				employee = new Employee(id, first, last, username, password, managerId, isManager, thisRequests);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return employee;
	}
	
	//add a new employee and return 
	public Employee addEmployee(String firstname, String lastname, String email, String password, int managerId,
			int isManager, ArrayList<Request> requests) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Employee employee = null;
		try
		{
			con = ConnectionUtil.getConnectionFromFile();
			String sql = "INSERT INTO Employee (Emp_FirstName, Emp_LastName, Emp_Email, Emp_Password, Manager_Id, IsManager) VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setInt(5, managerId);
			pstmt.setInt(6, isManager);
			pstmt.executeUpdate();

			//want to return the newly added employee
			//create query with the credentials we provided
			sql = "SELECT * FROM Employee WHERE Emp_Email = ? AND Emp_Password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("Employee_Id");
				//if the employee has requests, add them to the employee
				if(requests != null)
					employee = new Employee(id, firstname, lastname, email, password, managerId, isManager, requests);
				//otherwise, create an empty list of requests for this employee
				else
					employee = new Employee(id, firstname, lastname, email, password, managerId, isManager, new ArrayList<Request>());
			}
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			} 
			catch (Exception e1)
			{
				e.printStackTrace();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return employee;
	}

	public boolean updateEmployee(int id, String value, String columnName) {
		PreparedStatement pstmt = null;
		int employeesUpdated = 0;
		try{
			String sql = "";
			Connection con = ConnectionUtil.getConnectionFromFile();
			//update the column in the Employee table matching the columnName parameter
			//and change the column value to the value parameter
			sql = "UPDATE Employee SET " + columnName + " = ? WHERE Employee_Id = ?";
			pstmt = con.prepareStatement(sql);
			//if the field is the manager id or if the user is a manager, parse value into an Int
			if(value.matches("^[0-9]*$") && (columnName.equals("Manager_Id") || columnName.equals("IsManager")))
				pstmt.setInt(1, Integer.parseInt(value));
			else
				pstmt.setString(1, value);
			pstmt.setInt(2, id);
			// Save number returned from updated statement
			employeesUpdated = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(employeesUpdated > 0)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(int id) {
		PreparedStatement pstmt = null;
		int employeesDeleted = 0;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "DELETE FROM Employee WHERE Employee_Id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			// Save number returned from delete statement
			employeesDeleted = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(employeesDeleted > 0)
			return true;
		else
			return false;
	}

}
