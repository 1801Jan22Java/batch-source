package com.revature.servlet;

import com.revature.beans.Staff;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

public class Driver {

	public static void main(String[] args) {
		StaffDAO sd = new StaffDAOImpl();
		for(Staff e : sd.getAllStaff()) {
			System.out.println(e);
		}
		
		StaffDAO sd1 = new StaffDAOImpl();
	}

}
