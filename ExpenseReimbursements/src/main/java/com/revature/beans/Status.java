package com.revature.beans;

public class Status {
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int statusId, String statusCode) {
		super();
		this.statusId = statusId;
		this.statusCode = statusCode;
	}
	private int statusId;
	private String statusCode;
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusCode=" + statusCode + "]";
	}
}
