package com.revature.dao;


public interface ManagerDao {
	
	//Finds employee in the MANAGER table if they are a manager
	public boolean isManager(int employeeID);
}
