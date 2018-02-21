package com.revature.beans;

public class ReimbReq {
	
	/*
	 * reqStatus: "pending" when created by employee, "approved"/"denied" only by managers
	 * Managers may approve or deny in the frontend, updating this status
	 */
    private int reqId;
    private String reqName;
    private double amount;
    private int employeeId;
    private String reqStatus;
    private String receipt;
    private int modByManagerId;
	
	public ReimbReq() {
		super();
	}

	public ReimbReq(int reqId, String reqName, double amount, int employeeId, String reqStatus, String receipt,
			int modByManagerId) {
		super();
		this.reqId = reqId;
		this.reqName = reqName;
		this.amount = amount;
		this.employeeId = employeeId;
		this.reqStatus = reqStatus;
		this.receipt = receipt;
		this.modByManagerId = modByManagerId;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public int getModByManagerId() {
		return modByManagerId;
	}

	public void setModByManagerId(int modByManagerId) {
		this.modByManagerId = modByManagerId;
	}

	@Override
	public String toString() {
		return "ReimbReq [reqId=" + reqId + ", reqName=" + reqName + ", amount=" + amount + ", employeeId=" + employeeId
				+ ", reqStatus=" + reqStatus + ", receipt=" + receipt + ", modByManagerId=" + modByManagerId + "]";
	}

}
