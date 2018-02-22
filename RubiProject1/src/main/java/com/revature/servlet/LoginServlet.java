package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Staff;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.getRequestDispatcher("views/login.html").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StaffDAO  accessStaff = new StaffDAOImpl();
		Staff currStaff = accessStaff.getStaff(email);
		
		if(password.equals(currStaff.getPassword())) {
			session.setAttribute("email", email);
			session.setAttribute("firstName", currStaff.getFirstName());
			session.setAttribute("currEmpId", currStaff.getEmployeeId());
			session.setAttribute("problem", null);
			if(currStaff.getIsManager() == 1) {
				resp.sendRedirect("managerHome");
			} else {
				resp.sendRedirect("employeeHome");
			}
		} else {
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}
