package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimbursementRequest;

public interface ReimbursementRequestDAO {
	public void createReimbursementRequest(
			ReimbursementRequest req);

	public ReimbursementRequest getReimbursementRequestById(int id);

	public void deleteReimbursementRequest(ReimbursementRequest req);

	public List<ReimbursementRequest> getReimbursementRequests();

	public List<ReimbursementRequest> getReimbursementRequestsByEmplId(
			int emplId);

	public ReimbursementRequest updateReimbursementRequest(
			ReimbursementRequest req);

}
