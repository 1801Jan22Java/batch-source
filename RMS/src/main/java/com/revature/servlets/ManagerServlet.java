package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("empID") != null && (int)session.getAttribute("isManager") == 1) {
			req.getRequestDispatcher("ManagerPage.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("request") != null) {
			RequestDaoImpl rdi = new RequestDaoImpl();
			int requestID = Integer.parseInt(req.getParameter("requestID"));
			String status = req.getParameter("status");
			try {
				rdi.update(requestID, status, (int)session.getAttribute("employeeID"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("ManagerPage.html").forward(req, resp);
	}

}
