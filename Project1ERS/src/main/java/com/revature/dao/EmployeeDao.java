package com.revature.dao;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public Employee login(String email, String password);
	public Employee getEmployee (int employeeId);
	public boolean isManager(Employee thisManager);
	public boolean getAllEmployees(Employee thisManager);
	public boolean updateProfile(String firstname, String lastname, String email, String password, String jobTitle, Employee thisEmployee);
	public boolean addEmployee(String firstname, String lastname, String email, String jobTitle, Employee thisManager);
	public boolean isAvailable(String email);
}
