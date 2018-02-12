package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;

public interface ReimbursementRequestDao {
	
	public List<ReimbursementRequest> getReimbursementRequests();
	public List<ReimbursementRequest> getReimbursementRequestsByEmployee(Employee employee);
	public ReimbursementRequest getReimbursementRequestById(int id);
	
	

}
