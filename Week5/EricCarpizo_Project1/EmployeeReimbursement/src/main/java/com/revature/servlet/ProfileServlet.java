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
		//set the context type because we will be sending a json object with the response back to the client.
		response.setContentType("application/json");
		//get the currently signed in employee, which we know from the session's saved emplyoee id
		HttpSession session = request.getSession();
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee signedInEmployee = ed.getEmployeeById(Integer.parseInt(session.getAttribute("id").toString()));
		//we will use an ObjectMapper to map the objects in ecah object to a string.
		ObjectMapper mapper = new ObjectMapper();
		//String containing all employees
		String employeeString = null;
		//check if the user is not a manager
		if(signedInEmployee != null && signedInEmployee.getIsManager() == 0)
		{
			//provide json object for a non-manager employee
			employeeString = mapper.writeValueAsString(signedInEmployee.getRequests());
			response.getWriter().write("{\"employees\":"+employeeString+"}");
		}
		else {
			//provide the list of employeees minus the current user's id.
			List<Employee> employees = ed.getEmployees();
			employees.remove(Integer.parseInt((String)session.getAttribute("id")));
			response.getWriter().write("{\"employees\":"+employeeString+"}");
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
