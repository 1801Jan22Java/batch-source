package com.revature.beans;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

public class Request {
	
	private int reqId;
	private int empID;
	private String title;
	private float amount;
	private String description;
	private Timestamp date;
	private Blob reciept;
	private int walletID;
	private int status;
	private int managerID;
	
	public Request(int reqId, int empID, String title, float amount, String description, Timestamp date, Blob reciept, int walletID, int status, int manID) {
		super();
		this.reqId = reqId;
		this.empID = empID;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.reciept = reciept;
		this.walletID = walletID;
		this.status = status;
		this.managerID = manID;
	}
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Blob getReciept() {
		return reciept;
	}
	public void setReciept(Blob reciept) {
		this.reciept = reciept;
	}

	public int getWalletID() {
		return walletID;
	}

	public void setWalletID(int walletID) {
		this.walletID = walletID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	
}
