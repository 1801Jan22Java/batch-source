package com.revature.dao;

public interface ReimburseDAO {
	//	create table reimburse_request (
	//		    reimburse_request_id   number, 			// Sequence, trigger
	//		    user_id                number,			// Param
	//		    amount                 number(*,2),		// Param
	//		    notes                  clob,			// nothing
	//		    photo_url              varchar2(100)	// 
	
	// -An Employee can submit a reimbursement request
	public boolean reimburseRequest(int user_id, double amount);
	
	// -An Employee can upload an image of his/her receipt as part of the
	// reimbursement request
	public boolean reimburseRequest(int user_id, double amount, String url);

	// -An Employee can view their pending reimbursement requests
	// @param String 
	public String viewPendingRequests();

	// -An Employee can view their resolved reimbursement requests

	// -An Employee can view their information

	// -An Employee can update their information
	
	
	// -A Manager can approve/deny pending reimbursement requests

	// -A Manager can view all pending requests from all employees

	// -A Manager can view images of the receipts from reimbursement requests

	// -A Manager can view all resolved requests from all employees and see which
	// manager resolved it

	// -A Manager can view all Employees

	// -A Manager can view reimbursement requests from a single Employee

}
