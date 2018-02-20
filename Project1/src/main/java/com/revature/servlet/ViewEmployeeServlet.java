package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.*;
import com.revature.io.FileWriter;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
public class ViewEmployeeServlet extends HttpServlet {
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
		int empId = Integer.parseInt(req.getParameter("empId"));
		EmployeeDao edi = new EmployeeDaoImpl();
		Employee emp = edi.getEmployeeById(empId);
		String initString = this.getServletContext().getRealPath("/");
		FileWriter.writeSingleEmployee(initString + "empInfo.txt", emp);
		HttpSession session = req.getSession(false);
		session.setAttribute("empId", empId);
		ManagerDao mdi = new ManagerDaoImpl();
		FileWriter.writeFiles(initString + "singleEmployeeRequests.txt", mdi.getAllReqFromEmp(emp));
		resp.sendRedirect("viewEmployeeEnter");
	}

}
