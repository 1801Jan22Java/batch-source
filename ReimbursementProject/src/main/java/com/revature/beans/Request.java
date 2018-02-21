package com.revature.beans;

public class Request {

	private int requestId;
	private Employee employee;			// TODO: figure out how foreign keys work in Dao
	private RequestStatus requestStatus;
	private double requestAmount;
	private String requestComment;
	
	public Request() {
		super();
	}

	public Request(int requestId, Employee employee, RequestStatus requestStatus, double requestAmount,
			String requestComment) {
		super();
		this.requestId = requestId;
		this.employee = employee;
		this.requestStatus = requestStatus;
		this.requestAmount = requestAmount;
		this.requestComment = requestComment;
	}
	
	public Request(Employee employee, RequestStatus requestStatus, double requestAmount,
			String requestComment) {
		super();
		this.employee = employee;
		this.requestStatus = requestStatus;
		this.requestAmount = requestAmount;
		this.requestComment = requestComment;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequestComment() {
		return requestComment;
	}

	public void setRequestComment(String requestComment) {
		this.requestComment = requestComment;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employee=" + employee + ", requestStatus=" + requestStatus
				+ ", requestAmount=" + requestAmount + ", requestComment=" + requestComment + "]";
	}
}
