package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimbursementRequest;

public interface ReimbursementRequestDAO {
	public ReimbursementRequest createReimbursementRequest(
			ReimbursementRequest req);

	public ReimbursementRequest getReimbursementRequestById(int id);

	public void deleteReimbursementRequest(ReimbursementRequest req);

	public List<ReimbursementRequest> getReimbursementRequests();

	public List<ReimbursementRequest> getPendingReimbursementRequests();

	public List<ReimbursementRequest> getProcessedReimbursementRequests();

	public ReimbursementRequest updatePendingReimbursementRequest(
			ReimbursementRequest req);

	public ReimbursementRequest updateProcessedReimbursementRequest(
			ReimbursementRequest req);

	public ReimbursementRequest processReimbursementRequest(
			ReimbursementRequest req);

}
