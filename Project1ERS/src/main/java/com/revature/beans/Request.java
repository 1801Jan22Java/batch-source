package com.revature.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Request {
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int requestId, String requestType, String currentStatus, Employee currentManager, double amount, String description,
			LocalDate creationDate) {
		super();
		this.requestId = requestId;
		this.requestType = requestType;
		this.currentStatus = currentStatus;
		this.currentManager = currentManager;
		this.amount = amount;
		this.description = description;
		this.creationDate = creationDate;
	}
	private int requestId;
	private String requestType;
	private String currentStatus;
	private Employee currentManager = null;
	private double amount;
	private String description;
	private LocalDate creationDate;
	private ArrayList<Event> events = new ArrayList<>();
	private ArrayList<Upload> uploads = new ArrayList<>();
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public ArrayList<Upload> getUploads() {
		return uploads;
	}
	public Employee getCurrentManager() {
		return currentManager;
	}
	public void setCurrentManager(Employee currentManager) {
		this.currentManager = currentManager;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestType=" + requestType + ", currentStatus=" + currentStatus
				+ ", amount=" + amount + ", description=" + description + ", creationDate=" + creationDate;
	}

	
}
