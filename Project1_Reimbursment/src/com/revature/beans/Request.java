package com.revature.beans;

import java.time.LocalDate;

public class Request {

	public Request(int requestID, int employeeID, int managerID, Double amount, String description, String reply,
			String status, LocalDate date) {
		super();
		RequestID = requestID;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.amount = amount;
		this.description = description;
		this.reply = reply;
		this.status = status;
		this.date = date;
	}
	private int RequestID;
	private int employeeID; // in DB, requestID or "Request-er ID"
	private int managerID; // in DB, resolveID or "Resolver ID"
	private Double amount;
	private String description;
	private String reply;
	private String status;
	private LocalDate date;
	public int getRequestID() {
		return RequestID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public int getManagerID() {
		return managerID;
	}
	public Double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public String getReply() {
		return reply;
	}
	public String getStatus() {
		return status;
	}
	public LocalDate getDate() {
		return date;
	}

}
