package com.revature.beans;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReimbursementRequest {
	private int id;
	private double amount;
	private LocalDate dateReq;
	private int emplId;
	private String description;
	private Blob receipt;

	public ReimbursementRequest() {
		super();
	}

	public ReimbursementRequest(double amount, LocalDate dateReq,
			int emplId, Blob receipt, String description) {
		super();
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.description = description;
	}

	public ReimbursementRequest(int id, double amount, LocalDate dateReq,
			int emplId, Blob receipt, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public ReimbursementRequest setId(int id) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

	public double getAmount() {
		return amount;
	}

	public ReimbursementRequest setAmount(int amount) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

	public LocalDate getDateReq() {
		return dateReq;
	}

	public ReimbursementRequest setDateReq(LocalDate dateReq) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

	public int getEmplId() {
		return emplId;
	}

	public ReimbursementRequest setEmplId(int emplId) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

	public Blob getReceipt() {
		return receipt;
	}

	public ReimbursementRequest setReceipt(Blob receipt) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

	public String getDescription() {
		return description;
	}

	public ReimbursementRequest setDescription(String description) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description);
	}

}
