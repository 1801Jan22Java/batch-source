package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;

/**
 * A servlet used for retrieving all records submitted by a specified Employee.
 */
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);

		
		//Find the request logs belonging to the current employee
		RequestDaoImpl rdi = new RequestDaoImpl();
		List<Request> logs = rdi.readAllPendingRequests();
		List<Request> resolvedRequests = rdi.readAllResolvedRequests();
		for(Request r : resolvedRequests) {
			logs.add(r);
		}
		
		
		//Parse the information into JSON format
		Gson gson = new Gson();
		String parsedLogs = gson.toJson(logs);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");

		resp.getWriter().write(parsedLogs); 
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Update session with the first name to search for
		HttpSession session = req.getSession(false);
		
		session.setAttribute("firstName", req.getParameter("employeeFirstName"));
	}

}
