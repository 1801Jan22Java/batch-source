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
import com.revature.util.IncorrectCredentialsException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		session.setAttribute("username", username);
		String password = req.getParameter("password");
		String job = req.getParameter("job");
		String initString = this.getServletContext().getRealPath("/");
		if (job.equals("emp")) {
			Employee emp = this.checkEmployeeCredentials(username, password);
			if (emp == null) {
				resp.sendRedirect("WrongUsernameOrPassword.html");
			} else {
				FileWriter.writeSingleEmployee(initString + "empInfo.txt", emp);
				
				ReimbDao rdi = new ReimbDaoImpl();
				List<Reimb> allReimbs = rdi.getAllReqFromEmp(emp);
				List<Reimb> pendingReimbs = rdi.getAllPendingReqFromEmp(emp);
				List<Reimb> resolvedReimbs = rdi.getAllResolvedReqFromEmp(emp);
				FileWriter.writeFiles(initString + "allRequests.txt", allReimbs);
				FileWriter.writeFiles(initString + "allPendingRequests.txt", pendingReimbs);
				FileWriter.writeFiles(initString + "allResolvedRequests.txt", resolvedReimbs);
				
				resp.sendRedirect("employeeHome");
			}
		} else if (job.equals("mgr")) {
			Manager mgr = this.checkManagerCredentials(username, password);
			if (mgr == null) {
				resp.sendRedirect("WrongUsernameOrPassword.html");
			} else {
				FileWriter.writeSingleManager(initString + "mgrInfo.txt", mgr);
				
				ManagerDao mdi = new ManagerDaoImpl();
				List<Reimb> allReimbs = mdi.getAllReimbs();
				List<Reimb> pendingReimbs = mdi.getPendingReimbs();
				List<Reimb> resolvedReimbs = mdi.getResolvedReimbs();
				FileWriter.writeFiles(initString + "allRequests.txt", allReimbs);
				FileWriter.writeFiles(initString + "allPendingRequests.txt", pendingReimbs);
				FileWriter.writeFiles(initString + "allResolvedRequests.txt", resolvedReimbs);
				for (Reimb r : allReimbs) {
					byte[] bytes = r.getImage();
					int id = r.getReimbId();
					FileWriter.imageWriter(initString + id + ".jpg", bytes);
				}
				
				List<Employee> allEmps = mdi.getAllEmployees();
				FileWriter.writeEmployees(initString + "allEmployees.txt", allEmps);
				
				resp.sendRedirect("managerHome");
			}
		}
	}
	
	private Employee checkEmployeeCredentials(String username, String password) {
		EmployeeDao edi = new EmployeeDaoImpl();
		try {
			Employee emp = edi.login(username, password);
			return emp;
		} catch (IncorrectCredentialsException e) {
			return null;
		}
	}
	
	private Manager checkManagerCredentials(String username, String password) {
		ManagerDao mdi = new ManagerDaoImpl();
		try {
			Manager mgr = mdi.login(username, password);
			return mgr;
		} catch (IncorrectCredentialsException e) {
			return null;
		}
	}

}
