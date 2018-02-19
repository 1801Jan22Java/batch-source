package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employee;

public interface EmployeeDao {
	public List<Employee> getEmloyees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByCredentials(String username,String password);
	public int getEmployeeID(Employee employee);
	public void addEmployee(Employee employee); 
	public boolean validateCredentials(String username, String password);
	public Employee logout();
	public boolean validateManager(Employee employee);
	public Employee getManagerById(int id);
	public void deleteEmployee(Employee employee,Employee manager);
	public Employee createUser();
	public Employee getManager();
	List<Employee> getEmployees();
	public List<Employee> getEmployeesByManager(Employee manager);
	public Employee getEmployeeByUsername(String username);
	public void updateEmail(Employee emp, String email);
	public void updateFirstName(Employee emp, String fName);
	public void updateLastName(Employee emp, String lName);

}
