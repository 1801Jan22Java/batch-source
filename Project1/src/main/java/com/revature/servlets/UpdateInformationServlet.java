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

public class UpdateInformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("views/employeeupdateinformation.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
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
