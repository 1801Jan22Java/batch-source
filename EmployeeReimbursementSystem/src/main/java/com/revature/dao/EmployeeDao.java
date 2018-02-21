package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.Employee;


public interface EmployeeDao {

	public int createEmployee(int empID, String empFName, String empLName, String empEmail, String empAcc, String empPass, int isMan);
	public Employee getEmpByID(int empID);
	public Employee modifyEmployeeField(String empfield, String fieldVal, Employee empUser);
	public ArrayList<Employee> getAllEmployees();
	public Employee getEmpByAcc(String empAcc);
	
}
