package com.revature.dao;

import java.util.List;

import com.revature.beans.Department;

public interface DepartmentDao {
	
	public List<Department> getDepartments();
	public void getNameAvg(int dep_id);

}
