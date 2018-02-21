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

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		EmployeeDao emd = new EmployeeDaoImpl();
		RequestDao rd = new RequestDaoImpl();
		EventDao evd = new EventDaoImpl();
		UploadDao ud = new UploadDaoImpl();
		Employee thisEmployee = new Employee();
		String action = "";
		
		// Feature Request, put session info jSON as value of "myinfo" key of outer jSON
		//                  put current employee info jSON as value of "empinfo" key of outer jSON
		//                  if "myinfo" has employees js will provide manager only navigation
		if (session != null) {
			int employeeId = (int) session.getAttribute("employeeId");
			thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				action = "success";
				if (request.getParameter("id") != null && emd.isManager(thisEmployee)) {
					int thisEmployeeId = (int) Integer.valueOf(request.getParameter("id"));
					thisEmployee = emd.getEmployee(thisEmployeeId);
				}
				
				if (!rd.getRequests(thisEmployee)) {
					System.out.println("No Requests found for " + thisEmployee.getFirstname());
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