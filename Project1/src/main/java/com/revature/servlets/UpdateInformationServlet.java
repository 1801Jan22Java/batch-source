package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.beans.EmployeeInformation;
import com.revature.dao.EmployeeInformationDao;
import com.revature.dao.EmployeeInformationDaoSQL;

//TODO: double check and make sure the post request should be here

public class UpdateInformationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// if a get request is called then ensure the user is a valid employee before granting access to the html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			request.getRequestDispatcher("views/EmployeeUpdateInformation.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}

	}

	// if a post request is called, ensure that a valid employee is trying to access the information
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			
			// get the parameters which are from the form on the views/EmployeeUpdateInformation.html page
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String addrs = request.getParameter("address");
			EmployeeInformationDao ed = new EmployeeInformationDaoSQL();
			EmployeeInformation employeeInformation = ed.getEmployeeInformationByID((int)session.getAttribute("id"));
			if (employeeInformation != null) {
				ed.updateInformation(employeeInformation.getEmployeeInformationId(), email, fname, lname, addrs);
				request.getRequestDispatcher("employeehomepage").forward(request,response);
			}
			else {
				response.sendRedirect("updateinfo");
			}
		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

}
