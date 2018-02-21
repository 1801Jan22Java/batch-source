package com.revature.dao;

import java.util.List;

import com.revature.beans.RequestStatus;

public interface RequestStatusDao {

	public List<RequestStatus> getRequestStatuses();
	
	public RequestStatus getRequestStatusById(int requestStatusId);

}
