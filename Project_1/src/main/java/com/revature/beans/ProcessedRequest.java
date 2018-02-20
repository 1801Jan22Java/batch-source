package com.revature.beans;

import java.time.LocalDate;

public class ProcessedRequest {
	private int id;
	private int reqId;
	private RequestStatus status;
	private int managerId;
	private LocalDate datePro;

	public ProcessedRequest() {
		super();
	}

	public ProcessedRequest(int reqId, RequestStatus status, int managerId,
			LocalDate datePro) {
		super();
		this.reqId = reqId;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
	}

	public ProcessedRequest(int id, int reqId, RequestStatus status,
			int managerId, LocalDate datePro) {
		super();
		this.id = id;
		this.reqId = reqId;
		this.status = status;
		this.managerId = managerId;
		this.datePro = datePro;
	}

	public int getId() {
		return id;
	}

	public ProcessedRequest setId(int id) {
		return new ProcessedRequest(id, reqId, status, managerId, datePro);
	}

	public int getReqId() {
		return reqId;
	}

	public ProcessedRequest setReqId(int reqId) {
		return new ProcessedRequest(id, reqId, status, managerId, datePro);
	}

	public RequestStatus getStatus() {
		return status;
	}

	public ProcessedRequest setStatus(RequestStatus status) {
		return new ProcessedRequest(id, reqId, status, managerId, datePro);
	}

	public int getManagerId() {
		return managerId;
	}

	public ProcessedRequest setManagerId(int managerId) {
		return new ProcessedRequest(id, reqId, status, managerId, datePro);
	}

	public LocalDate getDatePro() {
		return datePro;
	}

	public ProcessedRequest setDatePro(LocalDate datePro) {
		return new ProcessedRequest(id, reqId, status, managerId, datePro);
	}

}
