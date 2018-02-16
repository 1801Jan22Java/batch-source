package com.revature.beans;

public class RequestLog {
	
	private int logID;
	private int requestID;
	private String response;
	private int managerID;
	private int statusID;
	private double dispensed;

	public RequestLog() {}
	
	public RequestLog(int logID, int requestID, String response, int managerID, int statusID) {
		super();
		this.logID = logID;
		this.requestID = requestID;
		this.response = response;
		this.managerID = managerID;
		this.statusID = statusID;
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
