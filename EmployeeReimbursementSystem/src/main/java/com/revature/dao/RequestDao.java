package com.revature.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.revature.beans.Request;


public interface RequestDao {

	public int createRequest(int requestID, int empID, int typeID, int statusID, String description, double amount,LocalDate statusDate,
				LocalDate subDate, int manID);
	public Request getReqByID(int reqID);
	public Request modifyReqStatus(int statID, Request req);
	public ArrayList<Request> getIncompleteRequests();
	public ArrayList<Request> getCompleteRequests();
	public ArrayList<Request> getRequestsByEmployee(int empID);
	
}
