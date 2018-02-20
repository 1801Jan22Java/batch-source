package com.revature.dao;

import java.util.List;

import com.revature.beans.ProcessedRequest;

public interface ProcessedRequestDAO {
	public ProcessedRequest getProcessedRequestById(int id);

	public void createProcessedRequest(ProcessedRequest pr);

	public List<ProcessedRequest> getProcessedRequests();

	public ProcessedRequest updateProcessedRequest(ProcessedRequest pr);

	public void deleteProcessedRequest(ProcessedRequest pr);
}
