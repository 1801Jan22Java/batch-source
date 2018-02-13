package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.EmployeeInformation;

public interface EmployeeInformationDao {

	public List<EmployeeInformation> getEmployeenformation();
	public Employee getEmployeeInformationByID(int employeeId);
	public int addEmployee(String username, String password, int employeeInformationId);	
	public boolean updateInformation();
}
