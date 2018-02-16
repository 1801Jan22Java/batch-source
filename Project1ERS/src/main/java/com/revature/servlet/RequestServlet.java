package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.*;
import com.revature.dao.*;

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 6737970915487991106L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		Employee thisEmployee = new Employee();
		boolean loggedIn = true;
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				// Check to see if this employee is a manager
				if (emd.isManager(thisEmployee)) {
					// If this employee is a manager provide a list of all employees to this object
					if (emd.getAllEmployees(thisEmployee)) {
						for(Employee e : thisEmployee.getEmployees()) {
							if (rd.getRequests(e)) {
								for(Request r : e.getRequests()) {
									System.out.println(e.getFirstname() + " - " + r.toString());
								}
							} else {
								System.out.println("No Requests found for " + e.getFirstname());
							}
						}
					}
				} else {
					// This employee is not a manager
					if (rd.getRequests(thisEmployee)) {
						for(Request r : thisEmployee.getRequests()) {
							System.out.println(thisEmployee.getFirstname() + " - " + r.toString());
						}
					} else {
						System.out.println("No Requests found for " + thisEmployee.getFirstname());
					}
				}
			} else {
				// This employeeId could not be found
				loggedIn = false;
			}
		} else {
			// This session could not be found
			loggedIn = false;
		}
		
		ObjectMapper om = new ObjectMapper();
		String jsonValue = "";
		if (loggedIn == true) {
			jsonValue = om.writeValueAsString(thisEmployee);
		} else {
			jsonValue = "{\"action\":\"login\"}";
		}
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(jsonValue);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
