package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("html/login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee e = ed.getEmployeeByUsernameAndPassword(username, password);
		if(e != null)
		{
			//if the user provides the correct username (which is their email) and password
			//create a session and save the user's id and credentials
			session.setAttribute("id", e.getId());
			session.setAttribute("problem", null);
			response.sendRedirect("home");
		}
		else
		{
			//writer.println("nope");
			session.setAttribute("Problem", "Incorrect username and password");
			response.sendRedirect("logout");
		}
	}
}
