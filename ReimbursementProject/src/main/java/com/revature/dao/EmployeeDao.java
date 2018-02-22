package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {

	// get all Employees for Manager page
	public List<Employee> getEmployees();
	
	// get Employee from EmployeeId, for Manager seeing requests for an individual employee
	public Employee getEmployeeById(int employeeId);
	
	// getEmployeeInfo for Employee info page
	// Can do this by simply using the get methods from the Employee returned by
	// the getEmployeeByEmployeeId method
	
	// TODO: To use these methods, must find out how to save employeeId from the logged in Employee
	// updateInformation;
	public void updateFirstName(int employeeId, String firstName);
	public void updateLastName(int employeeId, String lastName);
	public void updateAddress(int employeeId, String address);
	public void updateCity(int employeeId, String city);
	public void updateState(int employeeId, String state);
	public void updatePhoneNumber(int employeeId, String phoneNumber);
	public void updateEmail(int employeeId, String email);
	public void updatePassword(int employeeId, String password);
}
