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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee signedInEmployee = null;
		Employee queriedEmployee = null;
		Employee manager = null;
		if(request.getParameter("employeeId") != null)
		{
			queriedEmployee = ed.getEmployeeById(Integer.parseInt(request.getParameter("employeeId")));
			manager = ed.getEmployeeById(queriedEmployee.getManagerId());
		}
		else
		{
			signedInEmployee = ed.getEmployeeById(Integer.parseInt(session.getAttribute("id").toString()));
			manager = ed.getEmployeeById(signedInEmployee.getManagerId());
		}
		ObjectMapper mapper = new ObjectMapper();
		String employeeString = null;
		String managerString = null;
		if(signedInEmployee != null && (signedInEmployee.getId() != Integer.parseInt(session.getAttribute("id").toString()) || signedInEmployee.getIsManager() == 0))
		{
			employeeString = mapper.writeValueAsString(signedInEmployee);
			managerString = mapper.writeValueAsString(manager);
			response.getWriter().write("{\"employee\":"+employeeString+", \"manager\":"+managerString+"}");
		}
		else
		{
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
