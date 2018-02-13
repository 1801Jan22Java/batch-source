package com.revature.beans;

import java.sql.Blob;

public class Reimbursement {
	
	private int reimbursementId;
	private int employeeId;
	private int managerId;
	private int status;
	private double reimbursementValue;
	private Blob image; //TODO:idk what to do
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimbursementId, int employeeId, int managerId, int status, double reimbursementValue, Blob image) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.status = status;
		this.reimbursementValue = reimbursementValue;
		this.image = image;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public double getReimbursementValue() {
		return reimbursementValue;
	}

	public void setReimbursementValue(double reimbursementValue) {
		this.reimbursementValue = reimbursementValue;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", managerId="
				+ managerId + ", status=" + status + ", reimbursementValue=" + reimbursementValue + ", image=" + image
				+ "]";
	}

}
