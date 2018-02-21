package com.revature.dao;

import java.util.List;

import com.revature.beans.Manager;

public interface ManagerDao {

	public List<Manager> getManagers();
	
	public Manager getManagerById(int managerId);
	
}
