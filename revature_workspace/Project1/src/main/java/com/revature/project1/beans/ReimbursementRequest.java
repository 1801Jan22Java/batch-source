package com.revature.project1.beans;

public class ReimbursementRequest {
	private Employee employee;
	private Employee manager;
	private int pending;
	private int approved;
	private int receiptID;
	
	public ReimbursementRequest(){}
	
	public ReimbursementRequest(Employee employee) 
	{
		this.employee=employee;
	}
	
	public ReimbursementRequest(Employee employee, Employee manager, int pending, int approved, int receiptID)
	{
		this.employee=employee;
		this.manager=manager;
		this.pending=pending;
		this.approved=approved;
		this.receiptID=receiptID;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}
	
}
