package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;

public interface DepartmentDao {

	public List<Department> getDepartments();
	public Department getDepartmentByID(int id);
}
