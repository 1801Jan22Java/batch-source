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
    //our starting point after starting the server: localhost:8084/EmployeeReimbursement/login
  		//DD will map /login to the LoginServlet, and will determine to call the doGet, which will forward the login.html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("html/login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//A session is created
		HttpSession session = request.getSession();
		/*
		 Sets the content type of the response being sent to the client, 
		 if the response has not been committed yet. 
		 The given content type may include a character encoding specification, 
		 for example, text/html;charset=UTF-8. 
		 The response’s character encoding is only set from the given content type 
		 if this method is called before getWriter is called.
		 */
		response.setContentType("text/html");
		//retrieve the values from the form field's inputs corresponding to the names
		//"username" and "password", and save them.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDao ed = new EmployeeDaoImpl();
		//retrieve the employee with the matching credentials
		Employee e = ed.getEmployeeByUsernameAndPassword(username, password);
		//if an employee with the provided credentials match..
		if(e != null)
		{
			//if the user provides the correct username (which is their email) and password
			//create a session and save the user's id for retrieving the user's info later
			session.setAttribute("id", e.getId());
			//redirect the page to "home". The DD will map home to the MasterServlet,
			//MasterServlet will process the response using the RequestHelper process method.
			//the login form on our homepage has the action="login". The RequestHelper's
			//process method which will see that the action is login, and send the response to the 
			//TableServlet. See TableServlet do Post for what it will do to index.html page.
			//The Request Helper will call MasterServlet's doGet and load the index.html page
			response.sendRedirect("home");
			
		}
		else
		//otherwise, send the user to the logout servlet where they will be sent to the login page.
			response.sendRedirect("logout");
	}
}
