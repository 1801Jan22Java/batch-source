package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.beans.RequestLog;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestLogDaoImpl;

/**
 * Servlet implementation class ViewResolvedServlet
 */
public class ViewResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("ViewResolved.html");
		rd.forward(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get this employee's information
		HttpSession session = req.getSession(false);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee currentEmployee = edi.readEmployee("MickeyMouse@magic.com");
		//Employee currentEmployee = edi.readEmployee(session.getAttribute("email").toString());
		
		//Find the request logs belonging to the current employee
		RequestLogDaoImpl rldi = new RequestLogDaoImpl();
		List<RequestLog> logs = rldi.getRequestLogs(currentEmployee.getId());
		
		
		//Parse the information into JSON format
		Gson gson = new Gson();
		String parsedLogs = gson.toJson(logs);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");
		resp.getWriter().write(parsedLogs);
	}

}
