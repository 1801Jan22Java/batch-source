package com.revature.beans;

public class RequestStatus {

	private int requestStatusId;
	private String requestStatusName;
	
	public RequestStatus() {
		super();
	}

	public RequestStatus(int requestStatusId, String requestStatusName) {
		super();
		this.requestStatusId = requestStatusId;
		this.requestStatusName = requestStatusName;
	}
	
	public RequestStatus(String requestStatusName) {
		super();
		this.requestStatusName = requestStatusName;
	}

	public int getRequestStatusId() {
		return requestStatusId;
	}

	public void setRequestStatusId(int requestStatusId) {
		this.requestStatusId = requestStatusId;
	}

	public String getRequestStatusName() {
		return requestStatusName;
	}

	public void setRequestStatusName(String requestStatusName) {
		this.requestStatusName = requestStatusName;
	}

	@Override
	public String toString() {
		return "RequestStatus [requestStatusId=" + requestStatusId + ", requestStatusName=" + requestStatusName + "]";
	}
}
