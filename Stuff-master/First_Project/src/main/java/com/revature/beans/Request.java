package com.revature.beans;

public class Request {
	private int Request_Id,Request_Status,Type_Id,Employee_Id, Manager_Id;
	private double Amount;
	public Request () {
		super();
	}
	
	@Override
	public String toString() {
		return "Request [Request_Id=" + Request_Id + ", Request_Status=" + Request_Status + ", Type_Id=" + Type_Id
				+ ", Employee_Id=" + Employee_Id + ", Manager_Id=" + Manager_Id + ", Amount=" + Amount + "]";
	}

	public Request(int request_Id, int request_Status, int type_Id, int employee_Id, int manager_Id, double amount) {
		super();
		Request_Id = request_Id;
		Request_Status = request_Status;
		Type_Id = type_Id;
		Employee_Id = employee_Id;
		Manager_Id = manager_Id;
		Amount = amount;
	}

	public int getRequest_Id() {
		return Request_Id;
	}
	public void setRequest_Id(int request_Id) {
		Request_Id = request_Id;
	}
	public int getRequest_Status() {
		return Request_Status;
	}
	public void setRequest_Status(int request_Status) {
		Request_Status = request_Status;
	}
	public int getType_Id() {
		return Type_Id;
	}
	public void setType_Id(int type_Id) {
		Type_Id = type_Id;
	}
	public int getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}
	public int getManager_Id() {
		return Manager_Id;
	}
	public void setManager_Id(int manager_Id) {
		Manager_Id = manager_Id;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	

}
