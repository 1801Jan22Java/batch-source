package com.revature.dao;

import java.util.List;

import com.revature.beans.Request;

public interface RequestDao {
	List<Request> getRequests(int id);
	List<Request> getRequests();
	void createRequest(Request request);
	void ApproveRequest(int id, int manID);
	void DenyRequest(int id , int manID);
	Request GetRequest(int id);
}
