package com.revature.dao;

import java.util.Map;

public interface DepartmentDAO {

	public Map<String, Double> getAverageSalary();
	
	public void giveRaiseToDepartmentById(int depId);
	
	public void giveRaiseToDepartmentById(int depId, int perIncr);
	
}
