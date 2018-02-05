package com.revature.cc2.dao;

import com.revature.cc2.beans.Department;

public interface DepartmentDao {
	public Department getDepartmentByID(int id);
	public float getAverageSalary(int ID);
}
