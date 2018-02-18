package com.revature.dao;

import java.util.ArrayList;
import com.revature.beans.Employee;

public interface EmployeeDao {
	public int[] login(String username, String password) throws Exception;
	public ArrayList<Employee> viewInfo(int empID, int isManager) throws Exception;
	public void updateInfo(Employee emp) throws Exception;
}
