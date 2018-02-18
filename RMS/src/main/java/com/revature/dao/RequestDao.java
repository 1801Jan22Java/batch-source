package com.revature.dao;

import java.util.ArrayList;
import com.revature.beans.Request;

public interface RequestDao {
	public void submit(Request request) throws Exception;
	public ArrayList<Request> viewPending(int empID, int isManager) throws Exception;
	public ArrayList<Request> viewResolved(int empID, int isManager) throws Exception;
	public void update(int requestID, String status, int managerID) throws Exception;
}
