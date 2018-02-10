package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimburseLog;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimburseDAO {
	// create table reimburse_request (
	// reimburse_request_id number, // Sequence, trigger
	// user_id number, // Param
	// amount number(*,2), // Param
	// notes varchar2(140), // nothing
	// photo_url blob //

	/*
	 * Employee
	 */
	// -An Employee can view their pending reimbursement requests
	public List<Reimbursement> viewPendingRequests();

	// -An Employee can view their resolved reimbursement requests	
	public List<Reimbursement> viewResolved();

	// -An Employee can submit a reimbursement request
	public boolean reimburseRequest(int user_id, double amount);

	// -An Employee can upload an image of his/her receipt as part of the
	// reimbursement request
	public boolean uploadImage(String filename);

	/*
	 * Manager powers
	 */
	// -A Manager can approve pending reimbursement requests
	// Allow for partial reimbursements
	public boolean approveRequest(int request_id, double amount);

	// -A Manager can deny pending reimbursement requests
	public boolean denyRequest(int request_id);

	// -A Manager can view all pending requests from all employees
	// Return a list of all reimbursements, to be parsed into HTML
	public List<Reimbursement> getAllRequests();

	// -A Manager can view images of the receipts from reimbursement requests
	// Figure out image transfer via servlets, void return type for now
	public void viewImage(int request_id);

	// -A Manager can view reimbursement requests from a single Employee
	public User viewRequestEmp(int user_id);
	
	// -A Manager can view all resolved requests from all employees and see which
	// manager resolved it
	public List<ReimburseLog> getResolvedRequests();

}
// 10 requirements
