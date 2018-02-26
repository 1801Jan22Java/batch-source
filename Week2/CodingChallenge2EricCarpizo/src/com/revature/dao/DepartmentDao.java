package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;


public interface DepartmentDao 
{
	List<Department> getAllDepartments();
	Department getDepartmentById(int id);
}
