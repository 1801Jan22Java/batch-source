package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimbursementDAO {
	//Potentially need to add a file type
	public void submitReimbursement(User employee);
	public List<Reimbursement> empViewPendingReimbursementById(User emp);
	public List<Reimbursement> empViewRevolvedReimbursement(User emp);
	public void resolveReimbursement(User manager, int reimburseId, String action);
	public List<Reimbursement> viewAllPendingRequests(User manager);
	public List<Reimbursement> viewAllResolvedRequests(User manager);
	public List<Reimbursement> viewEmpRequests(User manager, int empId);	
	
	
}
