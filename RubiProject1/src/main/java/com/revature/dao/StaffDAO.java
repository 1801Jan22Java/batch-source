package com.revature.dao;

import com.revature.beans.Staff;
import java.util.List;

/*
 * EmployeeId NUMBER NOT NULL,
 * LastName VARCHAR2(20) NOT NULL,
 * FirstName VARCHAR2(20) NOT NULL,
 * Email VARCHAR2(60) NOT NULL,
 * Pass VARCHAR2(20) NOT NULL,
 * Username VARCHAR2(20),
 * IsManager NUMBER,
 * ReportsTo NUMBER
 */

public interface StaffDAO {
	
	// Adds a new staff member
	public int addNewStaff(String lastName, String firstName, String email, String password, String Username, int isManager, int reportsTo);
	
	// Gets all staff members from Staff table
	public List<Staff> getAllStaff();
	
	// Gets the staff info. by Email
	public Staff getStaff(String email);
	
	// Updates staff member information
	public int updateInfo(String lastName, String firstName, String email, String password, String username, int employeeId);

}
