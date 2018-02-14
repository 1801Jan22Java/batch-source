package com.revature.dao;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
	public boolean createEmployee(String firstName, String lastName, String email, String password);
	
	public Employee readEmployee(String email, String password);
	public Employee readEmployee(int employeeID);
}
