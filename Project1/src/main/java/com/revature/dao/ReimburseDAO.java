package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimburseDAO {
	// reimburse_request_id number,
	// user_id number,
	// amount number(*,2),
	// reimburse_status_id number,
	// notes varchar2(140),
	// resolved_by number,
	// photo_blob blob

	/*
	 * Employee
	 */
	// -An Employee can view their pending reimbursement requests
	public List<Reimbursement> viewPendingRequests(int user_id);

	// -An Employee can view their resolved reimbursement requests
	public List<Reimbursement> viewResolvedRequests(int user_id);

	/*
	 * Manager powers
	 */
	// -A Manager can approve pending reimbursement requests
	// Allow for partial reimbursements
	public boolean approveRequest(int request_id, double amount, int manager_id);

	// -A Manager can deny pending reimbursement requests
	public boolean denyRequest(int request_id, int manager_id);



	// -A Manager can view reimbursement requests from a single Employee
	public List<Reimbursement> viewRequestsEmp(int user_id);

	// -A Manager can view all resolved requests from all employees and see which
	// manager resolved it
	public List<Reimbursement> viewAllResolvedRequests();

	// -A Manager can view all pending requests from all employees
	// Return a list of all reimbursements, to be parsed into HTML
	public List<Reimbursement> viewAllPendingRequests();

	public boolean reimburseRequest(int user_id, double amount, String notes);
	
	
	/*
	 * Photo related methods
	 */
	// -A Manager can view images of the receipts from reimbursement requests
	// Figure out image transfer via servlets, void return type for now
	public void viewImage(int request_id);
	// -An Employee can upload an image of his/her receipt as part of the
	// reimbursement request
	public boolean uploadImage(String filename);

}
// 10 requirements
