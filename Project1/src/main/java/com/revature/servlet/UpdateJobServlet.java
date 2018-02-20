package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.*;

/**
 * Servlet implementation class UpdateJobServlet
 */
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String username = (String) session.getAttribute("username");
		String newJob = req.getParameter("job");
		String newPass = req.getParameter("password");
		EmployeeDao edi = new EmployeeDaoImpl();
		Employee emp = edi.getEmployeeByUsername(username);
		if (newJob != null) {
			emp.setJob(newJob);
		}
		if (newPass != null) {
			emp.setPassword(newPass);
		}
		edi.updateJobPass(emp);
		PrintWriter pw = new PrintWriter(this.getServletContext().getRealPath("/") + "empInfo.txt", "UTF-8");
		pw.println(emp.toString());
		pw.close();
		resp.sendRedirect("Updated.html");
	}

}
