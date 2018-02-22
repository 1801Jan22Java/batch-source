package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.EventDao;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.UploadDao;
import com.revature.dao.UploadDaoImpl;

public class RosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Return a list of all employees as a json
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
					if (!emd.getAllEmployees(thisEmployee)) {
						System.out.println("No Employees could be found");
					}
				} else {
					// This employee is not a manager
					// Future implementation = change to action = "not-found"
					loggedIn = false;
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
