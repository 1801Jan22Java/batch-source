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
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("You are Initializing the Employees information...");
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee signedInEmployee = ed.getEmployeeById(Integer.parseInt(session.getAttribute("id").toString()));
		ObjectMapper mapper = new ObjectMapper();
		String employeeString = null;
		if(signedInEmployee != null && signedInEmployee.getIsManager() == 0)
		{
			employeeString = mapper.writeValueAsString(signedInEmployee.getRequests());
			System.out.println(employeeString);
			response.getWriter().write("{\"employees\":"+employeeString+"}");
			System.out.println("Creating JSON obj for employee info...");
		}
		else {
			List<Employee> employees = ed.getEmployees();
			employees.remove(Integer.parseInt((String)session.getAttribute("id")));
			response.getWriter().write("{\"employees\":"+employeeString+"}");
			System.out.println("Creating JSON obj of employees info for manager...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
