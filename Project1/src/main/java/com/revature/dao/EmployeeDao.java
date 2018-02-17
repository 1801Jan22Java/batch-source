package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public String filename = "connection.properties";
	
	public List<Employee> getEmployees();
	public Employee getEmployeeByID(int requestedEmployeeId);
	public Employee getEmployeeByCredentials(String username, String password);
	public int addEmployee(String username, String password, String email, String firstname, String lastname, String address);	

}
