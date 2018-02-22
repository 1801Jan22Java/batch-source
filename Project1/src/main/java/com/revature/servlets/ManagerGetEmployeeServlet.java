package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

/**
 * Servlet implementation class ManagerGetEmployeeServlet
 */
public class ManagerGetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, forward the user to the requested html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			request.getRequestDispatcher("views/ManagerGetEmployee.html").forward(request, response);
		} else {
			response.sendRedirect("managerlogin");
		}
	}

	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, then obtain the information pertaining to all the employees
	// formated as a JSON object. The JSON object is an array of JSON objects within it. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			response.setContentType("application/json");
			EmployeeDao ed = new EmployeeDaoSQL();
			EmployeeInformationDao eid = new EmployeeInformationDaoSQL();
			List<Employee> listEmployee = ed.getEmployees();
			String JSONlist = "[";
			int i = 0;
			for(Employee emp : listEmployee) {
				i += 1;
				int employeeId = emp.getEmployeeId();
				EmployeeInformation requestedEmployeeInformation = eid.getEmployeeInformationByID(employeeId);
				JSONlist += "{\"fname\" : \"" + requestedEmployeeInformation.getFname() + "\"," ;
				JSONlist += "\"lname\" : \"" + requestedEmployeeInformation.getLname() + "\"," ;
				JSONlist += "\"empId\" : \"" + employeeId + "\"," ;
				JSONlist += "\"email\" : \"" + requestedEmployeeInformation.getEmail() + "\"," ;
				JSONlist += "\"address\" : \"" + requestedEmployeeInformation.getAddress() + "\"," ;
				JSONlist += "\"username\" : \"" + emp.getUsername() + "\",";
				JSONlist += "\"password\" : \"" + emp.getPassword() + "\"}";

				if (i < listEmployee.size()) {
					JSONlist += ",";
				}
			}
			JSONlist += "]";
			response.getWriter().write(JSONlist);

		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

}
