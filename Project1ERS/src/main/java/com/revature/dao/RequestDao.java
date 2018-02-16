package com.revature.dao;

import com.revature.beans.Employee;

public interface RequestDao {
	public boolean getRequests(Employee thisEmployee);
	public boolean addRequest(int requestTypeId, double amount, String description, Employee thisEmployee);
}
