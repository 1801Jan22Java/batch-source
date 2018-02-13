package com.revature.dao;

import java.util.List;

import com.revature.beans.EmployeeInformation;

public interface EmployeeInformationDao {
	
	public String filename = "connection.properties";

	public List<EmployeeInformation> getEmployeeInformation();
	public EmployeeInformation getEmployeeInformationByID(int employeeInformationId);
	public boolean updateInformation(int employeeInformationId,String email,String fname,String lname,String address);
}
