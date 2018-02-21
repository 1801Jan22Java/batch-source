package com.revature.beans;

public class ResolvedRequest {

	private int resolvedRequestId;
	private Manager manager;
	private Request request;
	private Employee employee;
	private RequestStatus requestStatus;
	private double requestAmount; // should call get methods for Request (request.getRequestAmount)
	private String requestComment; // should call get methods for Request (request.getRequestComment)
									// when passing in as a parameter

	public ResolvedRequest() {
		super();
	}

	public ResolvedRequest(int resolvedRequestId, Manager manager, Request request, Employee employee,
			RequestStatus requestStatus, double requestAmount, String requestComment) {
		super();
		this.resolvedRequestId = resolvedRequestId;
		this.manager = manager;
		this.request = request;
		this.employee = employee;
		this.requestStatus = requestStatus;
		this.requestAmount = requestAmount;
		this.requestComment = requestComment;
	}
	
	public ResolvedRequest(Manager manager, Request request, Employee employee,
			RequestStatus requestStatus, double requestAmount, String requestComment) {
		super();
		this.manager = manager;
		this.request = request;
		this.employee = employee;
		this.requestStatus = requestStatus;
		this.requestAmount = requestAmount;
		this.requestComment = requestComment;
	}

	public int getResolvedRequestId() {
		return resolvedRequestId;
	}

	public void setResolvedRequestId(int resolvedRequestId) {
		this.resolvedRequestId = resolvedRequestId;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
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

}
