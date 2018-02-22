package com.revature.beans;

import java.sql.Date;


/*
 * Holds all information related to a reimbursement request.
 */

public class Request {

	private int requestID;
	private int employeeID;
	private Date dateSubmitted;
	private int statusID;		//1=Pending, 2=Approved, 3=Declined
	private double amount;
	private String description;	//500 character string containing the reasoning behind the request.
	
	
	public Request() {}
	
	public Request(int requestID, int employeeID, Date dateSubmitted, int statusID, String description, double amount) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.dateSubmitted = dateSubmitted;
		this.statusID = statusID;
		this.description = description;
		this.amount = amount;
	}
	
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
