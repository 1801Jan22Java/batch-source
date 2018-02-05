package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Department;

public interface DepartmentDao {
	public ArrayList<Department> getAverages();
	public int getDeptIdByName(String deptName);
}
