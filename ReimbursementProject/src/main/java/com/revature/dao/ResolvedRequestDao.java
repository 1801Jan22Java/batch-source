package com.revature.dao;

import java.util.List;

import com.revature.beans.ResolvedRequest;

public interface ResolvedRequestDao {

	public List<ResolvedRequest> getAllResolvedRequests();
	
	public List<ResolvedRequest> getResolvedRequestsByEmployeeId(int employeeId);

	// switch request status in Request table from 1(pending) to 2(approved)
	// insert new ResolvedRequest into ResolvedRequest table with status of 2(pending)
	// callable statement, stored procedure
	public void approvePendingRequest(int requestId, int managerId);
	
	// switch request status in Request table from 1(pending) to 3(denied)
	// insert new ResolvedRequest into ResolvedRequest table with status of 3(denied)
	// callable statement, stored procedure
	public void denyPendingRequest(int requestId, int managerId);
	
}
