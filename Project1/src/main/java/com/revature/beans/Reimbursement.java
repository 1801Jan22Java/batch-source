package com.revature.beans;

import java.io.Serializable;

public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	private int reimburse_id;
	private int user_id;
	private double amount;
	private String notes;
	private String photo_url;

	public Reimbursement(int reimburse_id, int user_id, double amount, String notes, String photo_url) {
		super();
		this.reimburse_id = reimburse_id;
		this.user_id = user_id;
		this.amount = amount;
		this.notes = notes;
		this.photo_url = photo_url;
	}

	public Reimbursement() {
		super();
	}

	public int getReimburse_id() {
		return reimburse_id;
	}

	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

}
