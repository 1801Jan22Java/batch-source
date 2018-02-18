package com.revature.project1.dao;

import java.io.File;
import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;

public interface ReimbursementRequestDao {
	
	public List<ReimbursementRequest> getReimbursementRequests();
	public List<ReimbursementRequest> getReimbursementRequestsByEmployee(Employee employee);
	public ReimbursementRequest getReimbursementRequestById(int id);
	public void denyReimbursementRequest(int id, Employee manager);
	public void approveReimbursementRequest(int id, Employee manager);
	public void deleteReimbursementRequest(int id, Employee emp);
	void addReimbursementRequest(Employee emp, File file, float amount, String descript, String filename);
	
	

}
