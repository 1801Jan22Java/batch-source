package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int[] loginVar = null;
		try {
			loginVar = edi.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (loginVar == null) {
			resp.sendRedirect("login");
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeID", loginVar[0]);
			session.setAttribute("isManager", loginVar[1]);
			if (loginVar[1] == 1) {
				resp.sendRedirect("ManagerPage.html");
			} else {
				resp.sendRedirect("EmployeePage.html");
			}
		}
	}
}
