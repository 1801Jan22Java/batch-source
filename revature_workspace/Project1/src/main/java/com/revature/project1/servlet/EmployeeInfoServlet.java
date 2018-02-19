package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;

public class EmployeeInfoServlet extends HttpServlet {

	public EmployeeInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee e = ed.getEmployeeByUsername(username);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("views/employeeinfo.html");

		rd.include(request, response);
		pw.println("<div id=\"results\">");

		pw.println("<table class=\"requestTable\"><tr><th>Employee First Name</th><th>" + "Employee Last Name</th>"
				+ "<th>Employee Username</th>" + "<th>Employee Email</th>" + "<th>Employee ID</th>"
				+ "<th>Is Manager?</th>"+"<th>Manager</th>");
		ServletConfig config = getServletConfig();
		pw.println("<tr style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\"><td>"
				+ e.getFirstName() + "</td><td>" + e.getLastName() + "</td><td>" + e.getUserName() + "</td><td>"
				+ e.getEmail() + "</td><td>" + e.getEmployeeID() + "</td><td>" + e.getIsManager() + "</td>"
						+ "<td>" + e.getManager().getFirstName()+ " " +e.getManager().getLastName() + "</td></tr>");
		pw.println("</table></div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
