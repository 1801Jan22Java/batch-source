package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimb;
import com.revature.util.IncorrectCredentialsException;

public interface EmployeeDao {

	public Employee getEmployeeById(int empId);
	public Employee getEmployeeByUsername(String username);
	public Employee login(String username, String password) throws IncorrectCredentialsException;
	public List<Reimb> getAllReimbs(Employee emp);
	public List<Reimb> getPendingReimbs(Employee emp);
	public List<Reimb> getResolvedReimbs(Employee emp);
	public void makeRequest(Reimb r);
	public void updateJobPass(Employee emp);
	
}
