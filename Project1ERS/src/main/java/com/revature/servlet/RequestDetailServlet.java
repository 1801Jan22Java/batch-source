package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.*;
import com.revature.dao.*;

public class RequestDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		Employee thisEmployee = new Employee();
		String action = "";
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				if (request.getParameter("id") != null ) {
					int requestId = Integer.parseInt(request.getParameter("id"));
					// Check to see if this employee is a manager
					if (emd.isManager(thisEmployee)) {
						thisEmployee = rd.getRequestAuthor(requestId);
						if (thisEmployee != null) {
							if (evd.getEvents(thisEmployee.getRequests().get(0))) {
								if (ud.getUploads(thisEmployee.getRequests().get(0))) {
									action = "success";
								} else {
									action = "not-found";
								}
							} else {
								action = "not-found";
							}
						} else {
							action = "not-found";
						}
					} else {
						// This employee is not a manager
						if (rd.getRequests(thisEmployee)) {
							for(int i = thisEmployee.getRequests().size()-1; i >= 0 ; i--) {
								if (thisEmployee.getRequests().get(i).getRequestId() == requestId) {
									if (evd.getEvents(thisEmployee.getRequests().get(i))) {
										if (ud.getUploads(thisEmployee.getRequests().get(i))) {
											
										} else {
											action = "not-found";
										}
									} else {
										action = "not-found";
									}
								} else {
									thisEmployee.getRequests().remove(i);
								}
							}
							if (thisEmployee.getRequests().size()  > 0 && action != "not-found") {
								action = "success";
							} else {
								action = "not-found";
							}
						} else {
							action = "not-found";
						}
					}
				} else {
					action = "requests";
				}
			} else {
				// This employeeId could not be found
				action = "logout";
			}
		} else {
			// This session could not be found
			action = "login";
		}
		
		ObjectMapper om = new ObjectMapper();
		String jsonValue = "";
		if (action == "success") {
			jsonValue = om.writeValueAsString(thisEmployee);
		} else {
			jsonValue = "{\"action\":\"" + action + "\"}";
		}
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(jsonValue);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
