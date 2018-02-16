package com.revature.beans;

import java.sql.Blob;
import java.time.LocalDateTime;

public class ReimbursementRequest {
	private int id;
	private double amount;
	private LocalDateTime dateReq;
	private int emplId;
	private String description;
	private Blob receipt;
	private RequestStatus status;
	private int managerId;
	private LocalDateTime datePro;

	public ReimbursementRequest() {
		super();
	}

	public ReimbursementRequest(double amount, LocalDateTime dateReq, int emplId,
			Blob receipt, String description) {
		super();
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.description = description;
	}

	public ReimbursementRequest(int id, double amount, LocalDateTime dateReq,
			int emplId, Blob receipt, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.description = description;
	}

	public ReimbursementRequest(double amount, LocalDateTime dateReq, int emplId,
			Blob receipt, String description, RequestStatus status,
			int managerId, LocalDateTime datePro) {
		super();
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
		this.description = description;
	}

	public ReimbursementRequest(int id, double amount, LocalDateTime dateReq,
			int emplId, Blob receipt, String description, RequestStatus status,
			int managerId, LocalDateTime datePro) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public ReimbursementRequest setId(int id) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public double getAmount() {
		return amount;
	}

	public ReimbursementRequest setAmount(int amount) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public LocalDateTime getDateReq() {
		return dateReq;
	}

	public ReimbursementRequest setDateReq(LocalDateTime dateReq) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public int getEmplId() {
		return emplId;
	}

	public ReimbursementRequest setEmplId(int emplId) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public Blob getReceipt() {
		return receipt;
	}

	public ReimbursementRequest setReceipt(Blob receipt) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public RequestStatus getStatus() {
		return status;
	}

	public ReimbursementRequest setStatus(RequestStatus status) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public int getManagerId() {
		return managerId;
	}

	public ReimbursementRequest setManagerId(int managerId) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public LocalDateTime getDatePro() {
		return datePro;
	}

	public ReimbursementRequest setDatePro(LocalDateTime datePro) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

	public String getDescription() {
		return description;
	}

	public ReimbursementRequest setDescription(String description) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				description, status, managerId, datePro);
	}

}
