package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.util.InvalidActionException;

public interface RequestDao {
	
	public void addRequest(Request req);
	
	public ArrayList<Request> getEmployeeRequests(int id, ArrayList<Request> requests);
	
	public ArrayList<Request> getAllRequests();
	
	public void resolveRequest(Request r, Employee emp, String reply) throws InvalidActionException;
	
}
