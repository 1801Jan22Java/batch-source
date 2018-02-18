package com.revature.beans;

import java.sql.Date;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.RequestLogDaoImpl;

public class CompletedRequest {
	
	
	
	public CompletedRequest(int requestID) {
		super();
		
		//Grab the request by its ID
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RequestDaoImpl rdi = new RequestDaoImpl();
		RequestLogDaoImpl rldi = new RequestLogDaoImpl();
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		
		Request request = rdi.readRequestById(requestID);
		RequestLog requestLog = rldi.readRequestLog(requestID);
		
		//Get the employee's name
		Employee currEmp = edi.readEmployee(request.getEmployeeID());
		
		this.requestID = request.getRequestID();
		this.employeeName = currEmp.getFirstName() + " " + currEmp.getLastName();
		this.dateSubmitted = request.getDateSubmitted();
		this.statusID = request.getStatusID();
		this.amount = request.getAmount();
		this.managerName = mdi.getManagerName(requestLog.getManagerID());
		this.dispensed = requestLog.getDispensed();
		this.description = request.getDescription();
		this.response = requestLog.getResponse();
	}
	
	
	public CompletedRequest() {

	}


	private int requestID;
	private String employeeName;
	private Date dateSubmitted;
	private int statusID;
	private double amount;
	private String managerName;
	private double dispensed;
	private String description;
	private String response;
	
	
	
	
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeID(String employeeName) {
		this.employeeName = employeeName;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDispensed() {
		return dispensed;
	}
	public void setDispensed(double dispensed) {
		this.dispensed = dispensed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
