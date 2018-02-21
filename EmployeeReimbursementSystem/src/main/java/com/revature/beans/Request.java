package com.revature.beans;

import java.time.LocalDate;

public class Request {
	

	public Request(int requestID, int empID, int typeID, int statusID, String description, double amount,
			LocalDate statusDate, LocalDate submitDate, int manID) {
		super();
		this.requestID = requestID;
		this.empID = empID;
		this.typeID = typeID;
		this.statusID = statusID;
		this.description = description;
		this.amount = amount;
		this.statusDate = statusDate;
		this.submitDate = submitDate;
		this.manID = manID;
	}
	
	private int requestID;
	private int empID;
	private int typeID;
	private int statusID;
	private String description;
	private double amount;
	private LocalDate statusDate;
	private LocalDate submitDate;
	private int manID;
	
	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
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

	public LocalDate getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(LocalDate statusDate) {
		this.statusDate = statusDate;
	}
	
	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}
	
	public int getManID() {
		return manID;
	}

	public void setManID(int manID) {
		this.manID = manID;
	}
	
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", empID=" + empID + ", typeID=" + typeID + ", statusID=" + statusID
				+ ", description=" + description + ", amount=" + amount + ", statusDate=" + statusDate + ", submitDate=" + submitDate +
				", manID=" + manID + "]";
	}
	
}
