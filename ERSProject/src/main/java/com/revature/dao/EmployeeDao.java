package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	List<Employee> getEmployees();
	Employee login(String username, String password);
	Employee getEmployee(int id);
	void register(String email, String password);
	void changeEmail(String oldEmail, String newEmail);
	boolean isEmailRegistered(String email);
	boolean isEmployeeManager(String email);
	Employee getEmployee(String email);
}
