package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimbReq;

public interface ReimbReqDAO {

	/* 
	 * ReqId NUMBER NOT NULL,
	 * ReqName VARCHAR2(20),
	 * EmployeeId NUMBER NOT NULL,
	 * ModByManagerId NUMBER NOT NULL, 
	 * ReqStatus VARCHAR2(20), 
	 * Receipt BLOB, 
	 * CONSTRAINT PK_ReimbReq PRIMARY KEY (ReqId)
	 */
	
	/*
	 * Adds new request
	 */
	public int addNewReimbReq(String reqName, int employeeId, String reqStatus);
	
	/*
	 * ALL PENDING
	 */
	public List<ReimbReq> getAllPendingReq();
	
	/* Get "pending" reimbursement request by employeeId
	 * accessed by employee
	 */
	public List<ReimbReq> getPendingReimb(int employeeId);
	
	// ALL RESOLVED
	public List<ReimbReq> getAllResolvedReq();
	
	// Get "resolved" reimbursement request by employeeId
	public List<ReimbReq> getResolvedReimb(int employeeId);
	
	//Update reimbursement status
	public int updateStatus(String reqStatus);
	
	
}
