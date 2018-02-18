package com.revature.dao;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
	public boolean createEmployee(String firstName, String lastName, String email, String password);
	
	public Employee readEmployee(String email);
	public Employee readEmployee(int employeeID);
	
	public void updateEmployeeFirstName(int empID, String firstName);
	public void updateEmployeeLastName(int empID, String lastName);
	public void updateEmployeeEmail(int empID, String email);
}
