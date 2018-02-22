package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.EventDao;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.UploadDao;
import com.revature.dao.UploadDaoImpl;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// Update profile information
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		Employee thisEmployee = new Employee();
		int thisEmployeeId = 0;
		String action = "";
		String warning = "";
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				// If user is a manager allow allow changes to apply to different person
				if (request.getParameter("employee-id") != null && emd.isManager(thisEmployee)) {
					thisEmployeeId = (int) Integer.valueOf(request.getParameter("employee-id"));
					thisEmployee = emd.getEmployee(thisEmployeeId);
				}
				String email = "";
				if (request.getParameter("email") != null) {
					email = request.getParameter("email");
					// Email field is limited to 40 characters in database
					if (email.equals(thisEmployee.getEmail()) || email.length() > 40) {
						email = "";
					} else {
						if (!emd.isAvailable(email)) {
							email = "";
							warning = "bad-email";
						}
					}
				}
				
				String firstname = "";
				if (request.getParameter("firstname") != null) {
					firstname = request.getParameter("firstname");
					// Firstname field is limited to 40 characters in database
					if (firstname.equals(thisEmployee.getFirstname()) || firstname.length() > 40) {
						firstname = "";
					}
				}
				String lastname = "";
				if (request.getParameter("lastname") != null) {
					lastname = request.getParameter("lastname");
					// Lastname field is limited to 40 characters in database
					if (lastname.equals(thisEmployee.getLastname()) || lastname.length() > 40) {
						lastname = "";
					}
				}
				
				String password = "";
				if (request.getParameter("password") != null) {
					password = request.getParameter("password");
					password = getHash(password);
				}
				String jobTitle = "";
				if (request.getParameter("job-title") != null) {
					jobTitle = request.getParameter("job-title");
					// Job Title field is limited to 60 characters in database
					if (jobTitle.equals(thisEmployee.getJobTitle()) || jobTitle.length() > 60) {
						jobTitle = "";
					}
				}
				if (firstname == "" && lastname == "" && email == "" && password == "" && jobTitle == "") {
					action = "fail";
				} else {
					if (emd.updateProfile(firstname, lastname, email, password, jobTitle, thisEmployee)) {
						action = "success";
					} else {
						action = "fail";
					}
				}
			}
			else {
				action = "logout";
			}
		} else {
			action = "login";
		}
		if (action == "logout" || action == "login") {
			response.sendRedirect("../" + action + "?action=login");
			
		} else {
			if (!warning.equals("")) {
				warning = "&warning=" + warning;
			}
			if (thisEmployeeId > 0) {
				response.sendRedirect("../profile?id=" + thisEmployeeId + "&action=" + action + warning);
			} else {
				response.sendRedirect("../profile?action=" + action + warning);
			}
		}
	}
	
	private static String getHash(String originalString) {
		String newString = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			newString = bytesToHex(encodedhash);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return newString;
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	
}