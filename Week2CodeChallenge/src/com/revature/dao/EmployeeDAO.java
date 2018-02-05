package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	
}
