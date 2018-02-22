package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public ArrayList<Employee> getAllEmployees();

	public ArrayList<Employee> getManagers();

	public ArrayList<Employee> getEmployees();

	public Employee getEmployeeById(int id);
}
