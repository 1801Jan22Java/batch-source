package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;
import com.revature.beans.Employee;

public interface DepartmentDAO {
	public List<Department> getAllDepartments();
	public Department getDepartmentById(int id);
	public List<Employee> giveSalaryRaise(int id);
}
