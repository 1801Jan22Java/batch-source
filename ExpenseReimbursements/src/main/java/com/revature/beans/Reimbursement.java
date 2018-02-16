package com.revature.beans;

import java.sql.Blob;
import java.util.Date;

public class Reimbursement {
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimburseId, User employee, User manager, double amount, Status status, Blob fileType, String dateSubmitted) {
		super();
		this.reimburseId = reimburseId;
		this.employee = employee;
		this.manager = manager;
		this.amount = amount;
		this.status = status;
		this.fileType = fileType;
		this.dateSubmitted = dateSubmitted;
	}
	
	private int reimburseId;
	private User employee;
	private User manager;
	private double amount;
	private Status status;
	private Blob fileType;
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
	public Blob getFileType() {
		return fileType;
	}
	public void setFileType(Blob fileType) {
		this.fileType = fileType;
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
		
		return "Reimbursement [employee=" + employee + ", manager=" + manager + ", status=" + status + ", fileType="
				+ fileType + ", dateSubmitted=" + dateSubmitted + "]";
	}

}
