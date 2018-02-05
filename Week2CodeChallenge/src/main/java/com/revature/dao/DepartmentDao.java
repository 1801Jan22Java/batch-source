package com.revature.dao;

import com.revature.beans.Department2;

public interface DepartmentDao {

	public void nameAvgSalary(int id);
	public Department2 getDepartment2ById(int id);
	public void giveRaise(int id);
	
}
