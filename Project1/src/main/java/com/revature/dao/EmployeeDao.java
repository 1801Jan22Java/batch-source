package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
	public String filename = "connection.properties";
	
	public List<Employee> getEmployee();
	public Employee getEmployeeByID(int requestedEmployeeId);
	public Employee getEmployeeByCredentials(String user, String password);
	public int addEmployee(String username, String password, String email, String firstname, String lastname, String address);	
	public void submitReimbursement(int employeeId, double reimbursementValue);
}
