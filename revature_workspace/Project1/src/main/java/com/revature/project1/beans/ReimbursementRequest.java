package com.revature.project1.beans;

public class ReimbursementRequest {
	private Employee employee;
	
	public ReimbursementRequest(){}
	
	public ReimbursementRequest(Employee employee) 
	{
		this.employee=employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
