package com.revature.beans;

import java.time.LocalDate;
import java.util.List;

public class Request 
{
	private int id;
	private int employeeId;
	private String employeeName;
	private LocalDate dateCreated;
	private double amount;
	private String status;
	private String purpose;
	private String employeeNotes;
	private int managerId;
	private String managerNotes;
	private Upload upload;
	
	public Request(int id, int employeeId, String employeeName, LocalDate dateCreated, double amount, String status, String purpose,
			String employeeNotes, int managerId, String managerNotes, Upload upload) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateCreated = dateCreated;
		this.amount = amount;
		this.status = status;
		this.purpose = purpose;
		this.employeeNotes = employeeNotes;
		this.managerId = managerId;
		this.managerNotes = managerNotes;
		this.upload = upload;
	}
	
	public Request(int employeeId, String employeeName, LocalDate dateCreated, double amount, String status, String purpose,
			String employeeNotes, int managerId, String managerNotes, Upload upload) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateCreated = dateCreated;
		this.amount = amount;
		this.status = status;
		this.purpose = purpose;
		this.employeeNotes = employeeNotes;
		this.managerId = managerId;
		this.managerNotes = managerNotes;
		this.upload = upload;
	}
	
	public Request() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getEmployeeNotes() {
		return employeeNotes;
	}
	public void setEmployeeNotes(String employeeNotes) {
		this.employeeNotes = employeeNotes;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerNotes() {
		return managerNotes;
	}
	public void setManagerNotes(String managerNotes) {
		this.managerNotes = managerNotes;
	}
	
	public Upload getUpload() {
		return upload;
	}

	public void setUpload(Upload upload) {
		this.upload = upload;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", employeeId=" + employeeId + ", employeeName=" + employeeName + ", dateCreated="
				+ dateCreated + ", amount=" + amount + ", status=" + status + ", purpose=" + purpose
				+ ", employeeNotes=" + employeeNotes + ", managerId=" + managerId + ", managerNotes=" + managerNotes
				+ ", upload=" + upload + "]";
	}
}
