package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Department;

public interface DepartmentDao {
	
	public void giveRaise(Department d);
	public ArrayList<Integer> getSalaries(Department d);
	
}
