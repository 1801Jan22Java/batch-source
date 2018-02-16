package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface RequestDao {
	
	public void addRequest(Request req);
	
	public void updateRequest(int id);
	
	public ArrayList<Request> getEmployeeRequests(int id);
	
	public ArrayList<Request> getAllRequests();
	
	public void revokeRequest(int id, Employee e); 
	
	public void resolveRequest(int id);
	
}
