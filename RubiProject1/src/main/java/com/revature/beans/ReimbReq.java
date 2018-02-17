package com.revature.beans;

public class ReimbReq {
	
	private int reimbId;
	private String reqName;
	private int employeeId;
	private int modByManagerId;
	/*
	 * reqStatus: "pending" when created by employee, "approved"/"denied" only by managers
	 * Managers may approve or deny in the frontend, updating this status
	 */
	private String reqStatus;
	private String receipt;
	
	public ReimbReq() {
		super();
	}

	public ReimbReq(int reimbId, String reqName, int employeeId, int modByManagerId, String reqStatus, String receipt) {
		super();
		this.reimbId = reimbId;
		this.reqName = reqName;
		this.employeeId = employeeId;
		this.modByManagerId = modByManagerId;
		this.reqStatus = reqStatus;
		this.receipt = receipt;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getModByManagerId() {
		return modByManagerId;
	}

	public void setModByManagerId(int modByManagerId) {
		this.modByManagerId = modByManagerId;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "ReimbReq [reimbId=" + reimbId + ", employeeId=" + employeeId + ", ModByManagerId=" + modByManagerId + ", reqStatus="
				+ reqStatus + "]";
	}

}
