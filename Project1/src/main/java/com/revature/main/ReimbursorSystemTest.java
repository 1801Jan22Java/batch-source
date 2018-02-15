package com.revature.main;

import java.sql.Connection;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimburseOracle;
import com.revature.dao.UserOracle;
import com.revature.util.ReimburseUtil;
import com.revature.util.UserUtil;

public class ReimbursorSystemTest {
	public static void main(String[] args) {
		UserOracle uo = new UserOracle();
		Connection conn = null;
		ReimburseOracle ro = new ReimburseOracle();
		List<Reimbursement> rlist = ro.viewAllRequestsEmp("asdf");
//		for(Reimbursement r : rlist) {
//			System.out.println(r.getAmount());
//		}
		
		UserUtil uu = new UserUtil();
		System.out.println(uu.login("asdf", "asdf"));
		System.out.println(uu.getUser("asdf").getFirstname());
		
		
		ReimburseUtil ru = new ReimburseUtil();
//		for(Reimbursement r: ru.getPending("asdf")) {
//		
//			System.out.println(r.getAmount());
//		}
		

//		List<User> users = uo.getAllEmployees();
//		for (User u : users) {
//			System.out.println(u.getFirstname() + " " + u.getLastname());
//		}
//
//		System.out.println("\nALL PENDING FOR USER #1");
//
//		List<Reimbursement> pending = ro.viewPendingRequests(1);
//
//		for (Reimbursement r : pending) {
//			System.out.println(r.getNotes());
//		}
//		System.out.println("\nALL RESOLVED FOR USER #7");
//		List<Reimbursement> resolved = ro.viewResolvedRequests(7);
//		for (Reimbursement r : resolved) {
//			System.out.println(r.getNotes());
//		}
//		System.out.println("\nALL RESOLVED REQUESTS");
//		List<Reimbursement> allresolved = ro.viewAllResolvedRequests();
//		for (Reimbursement r : allresolved) {
//			System.out.println(r.getNotes());
//		}
//		System.out.println("\nALL PENDING REQUESTS");
//		List<Reimbursement> allpending = ro.viewAllPendingRequests();
//		for (Reimbursement r : allpending) {
//			System.out.println(r.getNotes());
//		}
//		List<Reimbursement> allForOneEmp = ro.viewRequestsEmp(1);
//		for (Reimbursement r : allForOneEmp) {
//			System.out.println(r.getNotes());
//		}
//		ro.reimburseRequest(1, 200.00, "this is a note");
//		System.out.println(ro.approveRequest(5, 300.0, 1));
//		
		ro.approveRequest(3, 1000.00, 1);
		ro.reimburseRequest(1, 100, "test");
		ro.denyRequest(1, 1);
	}
}
