package com.revature.beans;

import java.util.Date;

public class Reimbursement {
	public Reimbursement() {
		super();
	}
	public Reimbursement(int reimburseId, User employee, User manager, double amount, Status status, String dateSubmitted) {
		super();
		this.reimburseId = reimburseId;
		this.employee = employee;
		this.manager = manager;
		this.amount = amount;
		this.status = status;
		this.dateSubmitted = dateSubmitted;
	}
	
	private int reimburseId;
	private User employee;
	private User manager;
	private double amount;
	private Status status;
	private String dateSubmitted;
	
	public int getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	@Override
	public String toString() {
		
		return "Reimbursement [employee=" + employee + ", manager=" + manager + ", status=" + status + ", dateSubmitted=" + dateSubmitted + "]";
	}

}
