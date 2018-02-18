package com.revature.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.*;
import com.revature.dao.*;
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
		String password = req.getParameter("password");
		String job = req.getParameter("job");
		if (job.equals("emp")) {
			Employee emp = this.checkEmployeeCredentials(username, password);
			if (emp == null) {
				session.setAttribute("problem", "Incorrect password");
				resp.sendRedirect("login");
			} else {
				PrintWriter pw = new PrintWriter(this.getServletContext().getRealPath("/") + "empInfo.txt", "UTF-8");
				pw.println(emp.toString());
				pw.close();
				ReimbDao rdi = new ReimbDaoImpl();
				List<Reimb> allReimbs = rdi.getAllReqFromEmp(emp);
				List<Reimb> pendingReimbs = rdi.getAllPendingReqFromEmp(emp);
				List<Reimb> resolvedReimbs = rdi.getAllResolvedReqFromEmp(emp);
				pw = new PrintWriter(this.getServletContext().getRealPath("/") + "allRequests.txt", "UTF-8");
				String str = "{ \"allReimbs\" : [ ";
				for (int i = 0; i < allReimbs.size(); i++) {
					if (i == allReimbs.size() - 1) {
						str = str + allReimbs.get(i).toString();
					} else {
						str = str + allReimbs.get(i).toString() + ", ";
					}
				}
				str += "] }";
				pw.println(str);
				pw.close();
				pw = new PrintWriter(this.getServletContext().getRealPath("/") + "allPendingRequests.txt", "UTF-8");
				str = "{ \"allReimbs\" : [ ";
				for (int i = 0; i < pendingReimbs.size(); i++) {
					if (i == pendingReimbs.size() - 1) {
						str = str + pendingReimbs.get(i).toString();
					} else {
						str = str + pendingReimbs.get(i).toString() + ", ";
					}
				}
				str += "] }";
				pw.println(str);
				pw.close();
				pw = new PrintWriter(this.getServletContext().getRealPath("/") + "allResolvedRequests.txt", "UTF-8");
				str = "{ \"allReimbs\" : [ ";
				for (int i = 0; i < resolvedReimbs.size(); i++) {
					if (i == resolvedReimbs.size() - 1) {
						str = str + resolvedReimbs.get(i).toString();
					} else {
						str = str + resolvedReimbs.get(i).toString() + ", ";
					}
				}
				str += "] }";
				pw.println(str);
				pw.close();
				session.setAttribute("username", username);
				resp.sendRedirect("employeeHome");
			}
		} else if (job.equals("mgr")) {
			Manager mgr = this.checkManagerCredentials(username, password);
			if (mgr == null) {
				session.setAttribute("problem", "Incorrect password");
				resp.sendRedirect("login");
			} else {
				session.setAttribute("username", username);
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
