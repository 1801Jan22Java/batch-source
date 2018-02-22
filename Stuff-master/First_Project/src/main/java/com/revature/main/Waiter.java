package com.revature.main;

import java.sql.Connection;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.ConnectionUtil;

public class Waiter {
	EmployeeDaoImpl emp = new EmployeeDaoImpl();
	
	public boolean getAuth(String username,String password){
		if(emp.getAuthorization(username, password)) {
			return true;
		}else {
			return false;
		}
	}

}
