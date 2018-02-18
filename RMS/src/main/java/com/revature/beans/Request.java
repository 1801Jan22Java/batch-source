package com.revature.beans;

import java.sql.Timestamp;

public class Request {
	private int requestID;
	private int employeeID;
	private float amount;
	private String description;
	private String filename;
	private Timestamp timestamp;
	private String status;
	private int managerID;
	
	public Request(int requestID, int employeeID, float amount, String description, String filename, Timestamp timestamp,
			String status, int managerID) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.description = description;
		this.filename = filename;
		this.timestamp = timestamp;
		this.status = status;
		this.managerID = managerID;
	}
	public Request(int employeeID, float amount, String description, String filename) {
		super();
		this.requestID = 0;
		this.employeeID = employeeID;
		this.amount = amount;
		this.description = description;
		this.filename = filename;
		this.timestamp = null;
		this.status = "";
		this.managerID = 0;
	}
	public Request() {
		super();
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRequestID() {
		return requestID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public String getFilename() {
		return filename;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
}
