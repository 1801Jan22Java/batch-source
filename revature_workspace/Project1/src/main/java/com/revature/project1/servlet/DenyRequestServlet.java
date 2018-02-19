package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class DenyRequestServlet
 */
public class DenyRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DenyRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqIDStr = request.getParameter("id");
		int reqID = Integer.parseInt(reqIDStr);
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee currentUser = edi.getEmployeeByCredentials(name, password);
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
		ReimbursementRequest rr = rdi.getReimbursementRequestById(reqID);
		rdi.denyReimbursementRequest(reqID, currentUser);

		PrintWriter pw = response.getWriter();
		pw.println(
				"<html><body style=\"background-color:black; color:white; width:450px;margin-left:auto;margin-right:auto;\">");
		pw.println("Request successfully denied!");
		pw.println("<a style=\"color:white\" href=\"approval\">Back to approval page.</a>");
		pw.write("</div></body></html>");
	}

}
