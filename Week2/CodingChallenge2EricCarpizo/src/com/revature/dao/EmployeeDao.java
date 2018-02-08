package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	List<Employee> getEmployees();
	Employee getEmployeeById(int id);
	void createEmployee(String firstname, String lastname, int department_id, int salary, String email);
	void deleteBankAccount(Employee employee);
}
