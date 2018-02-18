package com.revature.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.revature.beans.Request;

public interface RequestDao {
	
	public boolean createRequest(int empID, Date dateSubmitted, String description, double amount);
	
	public Request readRequestById(int reqID);
	public ArrayList<Request> readPendingRequests(int empID);
	public ArrayList<Request> readResolvedRequests(int empID);
	
	public ArrayList<Request> readAllPendingRequests();
	
	public Request updateRequest(int reqId, int newStatus);
}
