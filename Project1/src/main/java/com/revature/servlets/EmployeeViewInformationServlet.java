package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

//TODO: double check and make sure the post request should be here

public class EmployeeViewInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called on this servlet, check the users credentials through the session
	// if the user is not an employee with a valid username, then send the user back to the login page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			request.getRequestDispatcher("views/EmployeeViewInformation.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}

	}

	// if a post request is called, then make sure the user who is trying to access information is a valid employee. if
	// the user is not a valid employee then send a redirect back to the login page. if the user is a valid employee, then 
	// obtain the users information from the dao using the session attribute "id" which stores the user's employeeid. it then
	// obtains the inforamtion from the dao and packages the information in JSON formating
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			
			// set the content type and obtain the employee information from the dao using the session's id
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			response.setContentType("application/json");
			int id = (int)session.getAttribute("id");
			EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(id);
			
			// second check to make sure the user has a valid employeeId, if the information is null
			// then the user does not have a valid employee information
			if (requestedEmployeeInformation != null) {
				String JSONobj = "";
				JSONobj += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
				JSONobj +=  "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
				JSONobj +=  "\"email\" : \"" + requestedEmployeeInformation.getEmail() + "\"," ;
				JSONobj +=  "\"address\" : \"" + requestedEmployeeInformation.getAddress()  + "\"," ;
				JSONobj+=  "\"id\" : \"" + requestedEmployeeInformation.getEmployeeInformationId() + "\"}" ;
				response.getWriter().write(JSONobj);
				System.out.println(JSONobj);
			}
		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

}
