package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public interface EmployeeDao {

	public int getEmployee_ID();
	
	public boolean getAuthorization(String username, String password);
	public boolean is_Manager(String username, String password); 
	
	public String getEmployeeInfo(int employee_Id);
	
	public String getAllEmployeeInfo(); 
	public void updateEmployeeId(int employee_id); 

	public void updateRoleId(int role_id); 


	public void updateEmail(String email,int Employee_id); 
	public void updateUsername(String username,int Employee_id); 
	public void updatePassword(String password,int Employee_id); 

}
