package project1.dao;

import java.util.List;

import project1.beans.Employee;

public interface EmployeeDao {

	public Employee viewInfromationById(int Id);
	public List<Employee> getAllEmployees();
	public void updateEmployeeFirstName(String fName, int empId);
	public void updateEmployeeLastName(String lName, int empId);
	public void updateEmployeeUsername(String username, int empId);
	public void updateEmployeePassword(String password, int empId);
	public Employee login(String username, String password);
}
