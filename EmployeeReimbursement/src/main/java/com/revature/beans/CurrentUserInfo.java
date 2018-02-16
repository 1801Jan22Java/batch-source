package com.revature.beans;

import java.util.ArrayList;

import com.revature.dao.EmployeeDaoImpl;

public class CurrentUserInfo {

	private static String Username; // really employee email
	private static int userId;
	private static boolean isManager;
	public static String getUsername() {
		return Username;
	}
	public static void setUsername(String username) {
		Username = username;
	}
	public static int getUserId() {
		return userId;
	}
	public static void setUserId(int userId) {
		CurrentUserInfo.userId = userId;
	}
	public static boolean isManager() {
		return isManager;
	}
	public static void setManager(boolean isManager) {
		CurrentUserInfo.isManager = isManager;
	}
	
	public static boolean login(String email, String password) {
		boolean valid = false;
		EmployeeDaoImpl EDI = new EmployeeDaoImpl();
		ArrayList<Employee> users = EDI.getAllEmployees();
		for(Employee e : users) {
			if(e.getEmail().equals(email) && e.getPassword().equals(password)) {
				Username = email;
				userId = e.getEmployeeID();
				setManager(e.isManager());
				valid = true;
			}
		}
		return valid;
	}
	
	

}
