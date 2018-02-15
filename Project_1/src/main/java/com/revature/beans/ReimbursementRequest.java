package com.revature.beans;

import java.sql.Blob;
import java.util.Date;

public class ReimbursementRequest {
	private int id;
	private int amount;
	private Date dateReq;
	private int emplId;
	private String description;
	private Blob receipt;
	private RequestStatus status;
	private int managerId;
	private Date datePro;

	public ReimbursementRequest() {
		super();
	}

	public ReimbursementRequest(int amount, Date dateReq, int emplId,
			Blob receipt) {
		super();
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
	}

	public ReimbursementRequest(int id, int amount, Date dateReq, int emplId,
			Blob receipt) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
	}

	public ReimbursementRequest(int amount, Date dateReq, int emplId,
			Blob receipt, RequestStatus status, int managerId, Date datePro) {
		super();
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
	}

	public ReimbursementRequest(int id, int amount, Date dateReq, int emplId,
			Blob receipt, RequestStatus status, int managerId, Date datePro) {
		super();
		this.id = id;
		this.amount = amount;
		this.dateReq = dateReq;
		this.emplId = emplId;
		this.receipt = receipt;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
	}

	public int getId() {
		return id;
	}

	public ReimbursementRequest setId(int id) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public int getAmount() {
		return amount;
	}

	public ReimbursementRequest setAmount(int amount) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public Date getDateReq() {
		return dateReq;
	}

	public ReimbursementRequest setDateReq(Date dateReq) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public int getEmplId() {
		return emplId;
	}

	public ReimbursementRequest setEmplId(int emplId) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public Blob getReceipt() {
		return receipt;
	}

	public ReimbursementRequest setReceipt(Blob receipt) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public RequestStatus getStatus() {
		return status;
	}

	public ReimbursementRequest setStatus(RequestStatus status) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public int getManagerId() {
		return managerId;
	}

	public ReimbursementRequest setManagerId(int managerId) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public Date getDatePro() {
		return datePro;
	}

	public ReimbursementRequest setDatePro(Date datePro) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

	public String getDescription() {
		return description;
	}

	public ReimbursementRequest setDescription(String description) {
		return new ReimbursementRequest(id, amount, dateReq, emplId, receipt,
				status, managerId, datePro);
	}

}
