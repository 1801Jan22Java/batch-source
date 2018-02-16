package com.revature.dao;

import java.util.List;

import com.revature.beans.RequestLog;

public interface RequestLogDao {
	
	public boolean createRequestLog(int requestID, String response, int managerID, int statusID, double dispensed);
	
	public RequestLog readRequestLog(int requestID);
	
	public List<RequestLog> getRequestLogs(int employeeID);
}
