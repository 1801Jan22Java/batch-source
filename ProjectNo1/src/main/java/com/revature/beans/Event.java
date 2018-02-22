package com.revature.beans;

import java.time.LocalDate;

public class Event {

	public Event(int requestID, int employeeID, int managerID, String message) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.message = message;
	}

	public Event(int eventID, int requestID, int employeeID, int managerID, String message, LocalDate dayTime) {
		super();
		this.eventID = eventID;
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.message = message;
		this.dayTime = dayTime;
	}

	private int eventID;
	private int requestID;
	private int employeeID;
	private int managerID;
	private String message;
	private LocalDate dayTime;

	public int getEventID() {
		return eventID;
	}

	public int getRequestID() {
		return requestID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public int getManagerID() {
		return managerID;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getDayTime() {
		return dayTime;
	}

}
