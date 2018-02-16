package com.revature.main;

import java.util.Random;

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
		// This employee has one request accessible by thisEmployee.getRequests().get(0)
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
				
				//If this employee is a manager, allow them to add new employees if the employee doesn't already exists
				if (emd.isAvailable("barney@company.com")) {
					if (emd.addEmployee("Barney", "Rubble", "barney@company.com", "Accounting Director", thisManager)) {
						System.out.println(thisManager.getEmployees().get(thisManager.getEmployees().size()-1).toString());
					} else {
						System.out.println("This employee could not be added.");
					}
				} else {
					System.out.println("This email address already exists.");
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
		
		/*
		// An employee should be able to add a request for reimbursement if a duplicate request doesn't already exist
		// A drop down menu will store the common_lookup_id's for all available reimbursement types
		// 1085 = Medical
		// This new request is accessible by thisEmployee.getRequests().get(1)
		if (rd.addRequest(1085, 285.15, "I had to get vaccines before going to China.", thisEmployee)) {
			System.out.println(thisEmployee.getRequests().get(thisEmployee.getRequests().size()-1).toString());
		} else {
			System.out.println("The new request could not be added");
		}
		*/
		
		// If a file or files were included with the request or any future update to the request,
		// Generate a random string for the filename in the uploads directory, check to see if what was generated is unique,
		// If the random string is unique, save the file to the server with that filename and save that new filename to the database
		//    and save the original filename as the display name in the database for the new file
		// The request object will be accessible for the current request from the details view
		if (ud.isDuplicate("a16707a187.jpg")) {
			System.out.println("a16707a187.jpg is a duplicate");
		} else {
			System.out.println("a16707a187.jpg is available");
		}
		
		// Randomizer can go in the Dao if the dao can control how the file gets saved in the server
		// Randomizer could possibly go in a SQL procedure that returned the result, but would still need to know the extension
		Request currentRequest = thisEmployee.getRequests().get(0);
		
		
		/* JAVA RANDOMIZER = DISCARD
		String extension = "jpg";
		String randomFileName = "";
		do {
			randomFileName = getRandomString(10);
			System.out.println(randomFileName);
		}while(ud.isDuplicate(randomFileName + "." + extension));
		
		
		if (ud.addUpload("proof.jpg", randomFileName + "." + extension, currentRequest, thisEmployee)) {
			System.out.println("Random file name was generated by Java");
			System.out.println(currentRequest.getUploads().get(currentRequest.getUploads().size()-1).toString());
		} else {
			System.out.println("proof.jpg could not be added to the database");
		}
		*/
		
		
		/* !! Set the column to 255, set a filelength param in the server to 50, restrict filenames and extensions to that
		// SQL PROCEDURE DETERMINES RANDOM FILENAME
		if (ud.addUpload("judge.jpg", currentRequest, thisEmployee)) {
			System.out.println("Random file name was generated by Oracle PL/SQL");
			System.out.println(currentRequest.getUploads().get(currentRequest.getUploads().size()-1).toString());
		} else {
			System.out.println("judge.jpg could not be added to the database");
		}
		*/
		
		
		// Anyone can add an event to a request
		//if (evd.addEvent())
		
	}
	
	public static String getRandomString(int len) {
		/* ****************************************************************************************** */
		/* Random Password Generator from https://www.geeksforgeeks.org/generating-password-otp-java/ */
        //String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        //String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Small_chars + numbers;
        Random rndm_method = new Random();
        char[] passwordChars = new char[len];
        for (int i = 0; i < len; i++) {
        	passwordChars[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        /* ****************************************************************************************** */
        return new String(passwordChars);
        
	}

}
