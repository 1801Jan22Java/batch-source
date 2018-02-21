package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimbReq;

public interface ReimbReqDAO {


	
	/*
	 * Adds new request
	 */
	public int addNewReimbReq(String reqName, double amount, int employeeId, String reqStatus, String receipt);
	
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
