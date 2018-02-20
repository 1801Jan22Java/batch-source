package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.beans.Reimb;

public interface ReimbDao {
	
	public void createReimb(Reimb r);
	public List<Reimb> getAllReimbs();
	public List<Reimb> getPendingReimbs();
	public List<Reimb> getResolvedReimbs();
	public List<Reimb> getAllReqFromEmp(Employee emp);
	public List<Reimb> getAllPendingReqFromEmp(Employee emp);
	public List<Reimb> getAllResolvedReqFromEmp(Employee emp);
	public void approve(Manager mgr, int reimbId);
	public void deny(Manager mgr, int reimbId);
	
}
