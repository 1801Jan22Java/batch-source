package com.revature.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.revature.beans.Employee;
import com.revature.beans.RequestStatus;
import com.revature.beans.RequestType;

public interface RequestDao {
	public boolean getRequests(Employee thisEmployee);
	public boolean addRequest(int requestTypeId, double amount, String description, Employee thisEmployee);
	public ArrayList<RequestType> getRequestTypes();
	public Employee getRequestAuthor (int requestId);
	public ArrayList<RequestStatus> getRequestStatuses();
}
