package com.revature.beans;

// TODO: Update this bean and create a Dao and DaoImpl once receipt stuff is figured out
public class Receipt {
	
	private int receiptId;
	private Request request;
	
	public Receipt() {
		super();
	}

	public Receipt(int receiptId, Request request) {
		super();
		this.receiptId = receiptId;
		this.request = request;
	}
	
	public Receipt(Request request) {
		super();
		this.request = request;
	}

	public int getReceiptId() {
		return receiptId;
	}
	
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	
	
}
