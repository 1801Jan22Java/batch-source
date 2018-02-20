package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.beans.Reimb;
import com.revature.util.IncorrectCredentialsException;

public interface ManagerDao {

	public Manager getManagerById(int mgrId);
	public Manager getManagerByUsername(String username);
	public Manager login(String username, String password) throws IncorrectCredentialsException;
	public List<Reimb> getAllReimbs();
	public List<Reimb> getPendingReimbs();
	public List<Reimb> getResolvedReimbs();
	public void approve(Manager mgr, int reimbId);
	public void deny(Manager mgr, int reimbId);
	public List<Employee> getAllEmployees();
	public List<Reimb> getAllReqFromEmp(Employee emp);
	public List<Reimb> getAllPendingReqFromEmp(Employee emp);
	public List<Reimb> getAllResolvedReqFromEmp(Employee emp);
	
}
