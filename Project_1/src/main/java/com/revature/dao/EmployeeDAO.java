package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);

	public Employee createEmployee(Employee empl);

	public List<Employee> getEmployees();

	public Employee updateEmployee(Employee empl);

	public void deleteEmployee(Employee empl);

	public Employee signIn(String username, String password);

	public Employee getEmployeeByUsername(String username);

}
