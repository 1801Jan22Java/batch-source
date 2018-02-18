package com.revature.project1.beans;

import java.io.File;

public class ReimbursementRequest {
	private Employee employee;
	private Employee manager;
	private int pending;
	private int approved;
	private int requestID;
	private File file;
	private float amount;
	private String description;
	private String extent;

	public ReimbursementRequest(){}
	
	public ReimbursementRequest(Employee employee) 
	{
		this.employee=employee;
	}
	
	public ReimbursementRequest(Employee employee, Employee manager, int pending, int approved, float amount, 
			String desc)
	{
		this.employee=employee;
		this.manager=manager;
		this.pending=pending;
		this.approved=approved;
		this.amount=amount;
		this.description=desc;
	}
	public ReimbursementRequest(Employee employee, Employee manager, int pending, int approved,File file, float amount, 
			String desc)
	{
		this.employee=employee;
		this.manager=manager;
		this.pending=pending;
		this.approved=approved;
		this.amount=amount;
		this.description=desc;
	}
	public ReimbursementRequest(int requestID,Employee employee, Employee manager, int pending, int approved, File file, float amount,
			String desc,String extent)
	{
		this.requestID=requestID;
		this.employee=employee;
		this.manager=manager;
		this.pending=pending;
		this.approved=approved;
		this.file=file;
		this.amount=amount;
		this.description=desc;
		this.extent=extent;
	}
	public ReimbursementRequest(int requestID,Employee employee, Employee manager, int pending, int approved, float amount,
			String desc)
	{
		this.requestID=requestID;
		this.employee=employee;
		this.manager=manager;
		this.pending=pending;
		this.approved=approved;
		this.amount=amount;
		this.description=desc;
	}
	public ReimbursementRequest(Employee employee, File file, float amount)
	{
		this.employee=employee;
		this.file=file;
		this.amount=amount;
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

	@Override
	public String toString() {
		String approvedStr="";
		String pendingStr="";
		if(pending ==1 &&approved==0) 
		{
		approvedStr="not yet processed";
		}
		else if(pending==0 && approved==1) 
		{
			approvedStr="approved";
		}
		else {
			approvedStr="denied";
		}
		return "Reimbursement request: "+this.requestID +" from " + employee.getFirstName()+ " "+employee.getLastName()+
				" for an amount of " + amount + " has been " + approvedStr +  " by "+
				manager.getFirstName() + " " + manager.getLastName();
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public File getFile() {
	if(file!=null) {
		return file;}
	else {
		return null;
	}
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
}
