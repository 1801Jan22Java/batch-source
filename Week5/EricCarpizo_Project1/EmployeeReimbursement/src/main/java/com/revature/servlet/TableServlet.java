package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class TableServlet
 */
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//handles dynamic loading of user tables.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee signedInEmployee = null;
		Employee queriedEmployee = null;
		Employee manager = null;
		//check if an employees info was queried for by a manager who is signed in.
		if(request.getParameter("employeeId") != null)
		{
			//load that emplyoees info.
			queriedEmployee = ed.getEmployeeById(Integer.parseInt(request.getParameter("employeeId")));
			//get their manager's info
			manager = ed.getEmployeeById(queriedEmployee.getManagerId());
		}
		else
		{
			//otherwise, save the current user's info and their' manager's info.
			signedInEmployee = ed.getEmployeeById(Integer.parseInt(session.getAttribute("id").toString()));
			manager = ed.getEmployeeById(signedInEmployee.getManagerId());
		}
		//we will use an ObjectMapper to map the objects in ecah object to a string.
		ObjectMapper mapper = new ObjectMapper();
		//String containing a queried employees info
		String employeeString = null;
		//String containing this employee's manager's info
		String managerString = null;
		//check if the signed in employee is not a manager
		if(signedInEmployee != null && (signedInEmployee.getId() != Integer.parseInt(session.getAttribute("id").toString()) || signedInEmployee.getIsManager() == 0))
		{
			//if so, return the information regarding this user's information and their managers information
			employeeString = mapper.writeValueAsString(signedInEmployee);
			managerString = mapper.writeValueAsString(manager);
			response.getWriter().write("{\"employee\":"+employeeString+", \"manager\":"+managerString+"}");
		}
		else
		{
			//if here, we are getting the information of all employees, 
			//the info for any employee that the manager wants to view, the manager's info,
			//and the id of the current user
			List<Employee> employees = ed.getEmployees();
			employeeString = mapper.writeValueAsString(employees);
			response.getWriter().write("{\"employees\":"+employeeString+", \"employee\":"+mapper.writeValueAsString(signedInEmployee)
			+", \"manager\":"+mapper.writeValueAsString(manager)
			+", \"queriedEmployee\":"+mapper.writeValueAsString(queriedEmployee)+", \"current\":"+session.getAttribute("id")+"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
