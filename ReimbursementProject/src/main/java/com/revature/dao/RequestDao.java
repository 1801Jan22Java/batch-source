package com.revature.dao;

import java.util.List;

import com.revature.beans.Request;

public interface RequestDao {

	// get all requests from the RequestTable that have a status of 1(pending)
	public List<Request> getAllPendingRequests();
	
	public List<Request> getPendingRequestsByEmployeeId(int employeeId);	// all requests belonging to this employee
																// request status is 1, pending

	// TODO: figure out how to retrieve the info entered into the fields to call this method
	// the request status of this new request will be set to 1, pending
	public void submitNewRequest(int employeeId, double requestAmount, String requestComment);	
	
	public List<Request> getAllRequests();
	
	public Request getRequestById(int requestId);
	
}
