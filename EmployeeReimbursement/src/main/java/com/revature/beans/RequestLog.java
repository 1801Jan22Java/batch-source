package com.revature.beans;


/*
 * Contains all additional information that is added to a request
 * as it is approved or denied by a manager.
 */

public class RequestLog {
	
	private int logID;
	private int requestID;
	private String response;	//The manager's rationale.
	private int managerID;		//The ID of the manager who approved or denied the request.
	private int statusID;		//2=Approved, 3=Declined
	private double dispensed;	//The amount of money dispensed.
	
	private int employeeID;
	private String description;
	private double amount;		//Amount requested.

	public RequestLog() {}
	
	public RequestLog(int logID, int requestID, String response, int managerID, int statusID, double dispensed) {
		super();
		this.logID = logID;
		this.requestID = requestID;
		this.response = response;
		this.managerID = managerID;
		this.statusID = statusID;
		this.dispensed = dispensed;
	}
	
	
	public int getLogID() {
		return logID;
	}
	public void setLogID(int logID) {
		this.logID = logID;
	}
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public double getDispensed() {
		return dispensed;
	}

	public void setDispensed(double dispensed) {
		this.dispensed = dispensed;
	}
	
	
}
