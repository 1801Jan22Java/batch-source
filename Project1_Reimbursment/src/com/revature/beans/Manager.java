package com.revature.beans;

public class Manager extends Employee {

	public Manager(int employeeID, String firstName, String lastName, String email, String password, int reportsTo, String phone,
			String jobTitle, boolean manager, int active) {
		super(employeeID, firstName, lastName, email, password, reportsTo, phone, jobTitle, true, active);
		
	}
	

}
