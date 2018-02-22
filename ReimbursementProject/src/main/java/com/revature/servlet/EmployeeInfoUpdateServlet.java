package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class EmployeeInfoUpdateServlet
 */
public class EmployeeInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeInfoUpdateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {
			EmployeeDaoImpl edi = new EmployeeDaoImpl();

			int employeeId = Integer.parseInt((String) session.getAttribute("employeeid"));
			
			String updateSelection = request.getParameter("updateselection");
			String updateValue = request.getParameter("updatevalue");

			switch (updateSelection) {
			case "address":
				edi.updateAddress(employeeId, updateValue);
				break;
			case "city":
				edi.updateCity(employeeId, updateValue);
				break;
			case "state":
				edi.updateState(employeeId, updateValue);
				break;
			case "phonenumber":
				edi.updatePhoneNumber(employeeId, updateValue);
				break;

			default:
				break;
			}
			
			response.sendRedirect("employeehome");

		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
