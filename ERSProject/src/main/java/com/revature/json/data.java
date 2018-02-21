package com.revature.json;

import java.util.List;

public class data {
	private String network;
	private double available_balance;
	private double pending_received_balance;
	List<Balance> balances;
	
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
	public List<Balance> getBalances() {
		return balances;
	}
	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}
	
}
