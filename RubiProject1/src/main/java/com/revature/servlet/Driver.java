package com.revature.servlet;

import com.revature.beans.ReimbReq;
import com.revature.beans.Staff;
import com.revature.dao.ReimbReqDAO;
import com.revature.dao.ReimbReqDAOImpl;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

public class Driver {

	public static void main(String[] args) {

		StaffDAO sd = new StaffDAOImpl();
		ReimbReqDAO rrd = new ReimbReqDAOImpl();
		
		// Prints ALL Employees from Staff table
		System.out.println("List from print ALL:");
		for(Staff e : sd.getAllStaff()) {
			System.out.println(e);
		}
		
		// Gets all fields of Employee by email.
		Staff currStaff = sd.getStaff("jaja@gmail.com");
		System.out.println("\nList from get staff:");
		System.out.println(currStaff.toString());
		
		// Create a new reimbursement request.
		
		/*int addedRR = rrd.addNewReimbReq("beer", 3, "pending");
		System.out.println("Result from addNewReimb:");
		System.out.println(addedRR);*/
		
		/*int addedRR = rrd.addNewReimbReq("magazines", 2, "resolved");
		System.out.println("Result from addNewReimb:");
		System.out.println(addedRR);*/
		
		
		/*String lastName, String firstName, String email, String password, String username,
		int isManager, int reportsTo*/
		/*int addedStaff = sd.addNewStaff("Revolver", "Ocelot", "caliber38@gmail.com", "caliber1", null, 1, 0);
		System.out.println("\nResult from addNewStaff:");
		System.out.println(addedStaff);*/
		
		/*int addedStaff = sd.addNewStaff("Code", "Boss", "iAreBoss@gmail.com", "boss1", null, 0, 3);
		System.out.println("Result from addNewStaff:");
		System.out.println(addedStaff);*/
		
		// Prints PENDING request
		System.out.println("\nList of all PENDING request from employeeId = 3");
		for(ReimbReq r : rrd.getPendingReimb(3)) {
			System.out.println(r.getReqName());
			System.out.println(r);
		}
		
		System.out.println("\nList of all PENDING request");
		for(ReimbReq rs : rrd.getAllPendingReq()) {
			System.out.println(rs);
		}
		
		System.out.println("\nList of all RESOLVED request by employeeId = 3");
		for(ReimbReq rst : rrd.getResolvedReimb(3)) {
			System.out.println(rst.getReqName());
			System.out.println(rst);
		}
		
		System.out.println("\nList of ALL RESOLVED request:");
		for(ReimbReq rst : rrd.getAllResolvedReq()) {
			System.out.println(rst.getReqName());
			System.out.println(rst);
		}
		
		
	}

}
