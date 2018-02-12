package com.revature.main;

import com.revature.beans.*;
import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		
		// The login page asks for username and password, receives their full profile
		Employee thisEmployee = emd.login("leonard@company.com", "password");
		if (thisEmployee == null) {
			System.out.println("Login Failed");
		} else {
			System.out.println(thisEmployee.toString());
		}
		
		
		// The Employee home page gets all requests and toggles between opened and closed
		if (rd.getRequests(thisEmployee)) {
			for(Request r : thisEmployee.getRequests()) {
				System.out.println(r.toString());
			}
		} else {
			System.out.println("No Requests found");
		}
		
		// The Employee wants to get the details of a request, populate events of all their requests
		for (int i = 0; i < thisEmployee.getRequests().size(); i++) {
			if (evd.getEvents(thisEmployee.getRequests().get(i))) {
				for (Event e : thisEmployee.getRequests().get(i).getEvents())
				System.out.println(e.toString());
			} else {
				System.out.println("No Events found");
			}
		}
		
		// The Employee wants to get the files of a request, populate files of all their requests
		for (int i = 0; i < thisEmployee.getRequests().size(); i++) {
			if (ud.getUploads(thisEmployee.getRequests().get(i))) {
				for (Upload u : thisEmployee.getRequests().get(i).getUploads())
				System.out.println(u.toString());
			} else {
				System.out.println("No Uploads found");
			}
		}
		
		// Manager wants to login
		Employee thisManager = emd.login("bob@company.com", "password");
		if (thisManager == null) {
			System.out.println("Login Failed");
		} else {
			System.out.println(thisManager.toString());
		}
		
		// Check to see if this employee is a manager
		if (emd.isManager(thisManager)) {
			System.out.println(thisManager.getFirstname() + " is a manager.");
			
			// If this employee is a manager provide a list of all employees
			if (emd.getAllEmployees(thisManager)) {
				for(Employee e : thisManager.getEmployees()) {
					System.out.println(e.toString());
				}
				
				// If this employee is a manager and has a list of all employees, provide a list of all requests
				for (int i = 0; i < thisManager.getEmployees().size(); i++) {
					if (rd.getRequests(thisManager.getEmployees().get(i))) {
						for(Request r : thisManager.getEmployees().get(i).getRequests()) {
							System.out.println(thisManager.getEmployees().get(i).getFirstname() + " - " + r.toString());
						}
					} else {
						System.out.println("No Requests found for " + thisManager.getEmployees().get(i).getFirstname());
					}
				}
				
				//If this employee is a manager, allow them to add new employees
				if (emd.addEmployee("Barney", "Rubble", "barney@company.com", "Accounting Director", thisManager)) {
					System.out.println(thisManager.getEmployees().get(thisManager.getEmployees().size()-1).toString());
				}
				
				
			} else {
				System.out.println("No Employees found.");
			}
			
			
			
		} else {
			System.out.println(thisManager.getFirstname() + " is not a manager.");
		}
		
		// Update profile
		if (emd.updateProfile("Fred", "Flintstone", "fred@company.com", "cangetin", "Old Leonard", thisEmployee)) {
			System.out.println(thisEmployee.toString());
		} else {
			System.out.println("Update Failed");
		}
		
		// Put it back
		if (emd.updateProfile("Leonard", "Blumberg", "leonard@company.com", "password", "Software Developer", thisEmployee)) {
			System.out.println(thisEmployee.toString());
		} else {
			System.out.println("Update Failed");
		}
		
		
		
	}

}
