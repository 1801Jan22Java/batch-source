package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.io.FileWriter;

/**
 * Servlet implementation class ApproveDenyServlet
 */
public class ApproveDenyServlet extends HttpServlet {
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
		int reimbId = Integer.parseInt(req.getParameter("reimbId"));
		String verb = req.getParameter("verb");
		HttpSession session = req.getSession();
		ManagerDao mdi = new ManagerDaoImpl();
		Manager mgr = mdi.getManagerByUsername((String) session.getAttribute("username"));
		if (verb.equals("approve")) {
			mdi.approve(mgr, reimbId);
		} else {
			mdi.deny(mgr, reimbId);
		}
		String initString = this.getServletContext().getRealPath("/");
		List<Reimb> allReimbs = mdi.getAllReimbs();
		List<Reimb> pendingReimbs = mdi.getPendingReimbs();
		List<Reimb> resolvedReimbs = mdi.getResolvedReimbs();
		FileWriter.writeFiles(initString + "allRequests.txt", allReimbs);
		FileWriter.writeFiles(initString + "allPendingRequests.txt", pendingReimbs);
		FileWriter.writeFiles(initString + "allResolvedRequests.txt", resolvedReimbs);
		if (req.getParameter("reload").equals("all")) {
			resp.sendRedirect("managerHome");
		} else {
			Employee emp = new EmployeeDaoImpl().getEmployeeById((Integer) session.getAttribute("empId"));
			FileWriter.writeFiles(initString + "singleEmployeeRequests.txt", mdi.getAllReqFromEmp(emp));
			resp.sendRedirect("viewEmployeeEnter");
		}
	}

}
