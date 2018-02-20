package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Manager;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoSQL;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoSQL;

/**
 * Servlet implementation class ManagerLoginServlet
 */
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/ManagerLogin.html").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// set the correct content type
		response.setContentType("text/html");
		// from the form that was submitted
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// call the check credentials function to make sure the employees credentials
		// are a part of the database
		ManagerDao md = new ManagerDaoSQL();
		Manager resultManager = md.getManagerByCredentials(username, password);
		
		if (resultManager != null) {
			System.out.println("correct user");
			// set the session attributes so the username will be remembered
			session.setAttribute("username", username);
			session.setAttribute("id", resultManager.getManagerId());
			session.setAttribute("problem", null);
			request.getRequestDispatcher("managerhomepage").forward(request,response);
		} else {
			session.setAttribute("problem", "incorrect credentials");
			response.sendRedirect("managerlogin");
		}
		
	}

}
