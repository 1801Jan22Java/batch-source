package com.revature.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimbursementDAO {
	
	public void submitReimbursement(User employee, InputStream fileName, double amount);
	public List<Reimbursement> empViewPendingReimbursementById(User emp);
	public List<Reimbursement> empViewRevolvedReimbursement(User emp);
	public void resolveReimbursement(User manager, int reimburseId, String action);
	public List<Reimbursement> viewAllPendingRequests(User manager);
	public List<Reimbursement> viewAllResolvedRequests(User manager);
	public List<Reimbursement> viewEmpRequests(User manager, int empId);
	public ByteArrayOutputStream getRequestImage(int reimburseId);
	public int getSubmitUser(int reimburseId);
}
