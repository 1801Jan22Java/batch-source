package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {
	public String filename = "connection.properties";
	
	public List<Reimbursement> getReimbursement();
	public List<Reimbursement> getReimbursementByEmployeeId(int employeeId);
	public Reimbursement getReimbursementByID(int requestedReimbursementId);
	public int submitReimbursement(int employeeId, double reimbursementValue, byte [] byteArr);
	public void updateStatus(int reimbursementId, int managerId, int statusId);

}
