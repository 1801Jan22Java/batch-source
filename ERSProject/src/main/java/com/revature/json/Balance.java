package com.revature.json;

public class Balance {
	
	private int user_id;
	private String label;
	private String address;
	private double available_balance;
	private double pending_received_balance;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAvailable_balance() {
		return available_balance;
	}
	public void setAvailable_balance(double available_balance) {
		this.available_balance = available_balance;
	}
	public double getPending_received_balance() {
		return pending_received_balance;
	}
	public void setPending_received_balance(double pending_received_balance) {
		this.pending_received_balance = pending_received_balance;
	}
	
	
}
