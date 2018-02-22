package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface EmployeeDao 
{
	public List<Employee> getEmployees();

	public Employee getEmployeeById(int id);

	public Employee addEmployee(String firstname, String lastname, String email, String password, int managerId, int isManager, ArrayList<Request> requests);

	public boolean updateEmployee(int id, String value, String columnName);

	public boolean deleteEmployee(int id);
	
	public Employee getEmployeeByUsernameAndPassword(String username, String password);
}
