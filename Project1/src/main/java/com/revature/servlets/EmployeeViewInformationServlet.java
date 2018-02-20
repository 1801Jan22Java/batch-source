package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.revature.beans.*;
import com.revature.dao.*;


public class EmployeeViewInformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("views/employeeviewinformation.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			response.setContentType("application/json");
			int id = (int)session.getAttribute("id");
			EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(id);
			if (requestedEmployeeInformation != null) {
				String JSONobj = "";
				
				JSONobj += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
				JSONobj +=  "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
				JSONobj +=  "\"email\" : \"" + requestedEmployeeInformation.getEmail() + "\"," ;
				JSONobj +=  "\"address\" : \"" + requestedEmployeeInformation.getAddress()  + "\"," ;
				JSONobj+=  "\"id\" : \"" + requestedEmployeeInformation.getEmployeeInformationId() + "\"}" ;
				
				System.out.println(JSONobj);
				response.getWriter().write(JSONobj);
			}
		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

}
