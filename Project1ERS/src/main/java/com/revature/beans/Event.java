package com.revature.beans;

import java.time.LocalDate;

public class Event {
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(int eventId, Employee eventAuthor, String requestStatus, String message, LocalDate creationDate) {
		super();
		this.eventId = eventId;
		this.eventAuthor = eventAuthor;
		this.requestStatus = requestStatus;
		this.message = message;
		this.creationDate = creationDate;
	}
	private int eventId;
	private Employee eventAuthor;
	private String requestStatus;
	private String message;
	private LocalDate creationDate;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Employee getEventAuthor() {
		return eventAuthor;
	}
	public void setEventAuthor(Employee eventAuthor) {
		this.eventAuthor = eventAuthor;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventAuthor=" + eventAuthor + ", requestStatus=" + requestStatus
				+ ", message=" + message + ", creationDate=" + creationDate + "]";
	}
}
