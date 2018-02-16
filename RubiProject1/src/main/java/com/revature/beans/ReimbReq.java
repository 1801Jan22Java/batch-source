package com.revature.beans;

public class ReimbReq {
	
	private int reimbId;
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

	public ReimbReq(int reimbId, int employeeId, int managerId, String reqStatus, String receipt) {
		super();
		this.reimbId = reimbId;
		this.employeeId = employeeId;
		this.modByManagerId = managerId;
		this.reqStatus = reqStatus;
		this.receipt = receipt;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
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

	public void setModByManagerId(int managerId) {
		this.modByManagerId = managerId;
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
		return "ReimbReq [reimbId=" + reimbId + ", employeeId=" + employeeId + ", managerId=" + modByManagerId + ", reqStatus="
				+ reqStatus + "]";
	}

}
