package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimburseLog;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public class ReimburseOracle implements ReimburseDAO {

	@Override
	public List<Reimbursement> viewPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reimburseRequest(int user_id, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uploadImage(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveRequest(int request_id, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean denyRequest(int request_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reimbursement> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewImage(int request_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User viewRequestEmp(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburseLog> getResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
