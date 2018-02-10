package com.revature.beans;

import java.io.Serializable;

public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	private int reimburse_id;
	private int reimburse_status_id;
	private int user_id;
	private double amount;
	private String notes;
	// Temporarily removed from constructor til we learn how it's gonna be displayed
	// or til I figure out how to get it into an output stream.
	private String photo_url;
	private int resolved_by;

	public Reimbursement(int reimburse_id, int reimburse_status_id, int user_id, double amount, String notes,
			int resolved_by) {
		super();
		this.reimburse_id = reimburse_id;
		this.user_id = user_id;
		this.amount = amount;
		this.notes = notes;
		this.reimburse_status_id = reimburse_status_id;
		this.resolved_by = resolved_by;
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

	public int getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(int resolved_by) {
		this.resolved_by = resolved_by;
	}

	public int getReimburse_status_id() {
		return reimburse_status_id;
	}

	public void setReimburse_status_id(int reimburse_status_id) {
		this.reimburse_status_id = reimburse_status_id;
	}

}
