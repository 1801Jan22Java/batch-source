package com.revature.dao;

import java.sql.Blob;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {
	public String filename = "connection.properties";
	
	public List<Reimbursement> getReimbursement();
	public Reimbursement getReimbursementByID(int requestedReimbursementId);
	public int sumbitReimbursement(int employeeId, double reimbursementValue, Blob image);
	public boolean updateStatus(int reimbursementId, int managerId, int statusId);

}
