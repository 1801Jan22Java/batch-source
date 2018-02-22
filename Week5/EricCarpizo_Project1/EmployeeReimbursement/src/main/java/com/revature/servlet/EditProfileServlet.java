package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//save the inputs from the user
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDao ed = new EmployeeDaoImpl();	
		//If no input is provided, it will not be updated.
		//If input is provided, update the user's information based on those inputs.
		if(email.length() > 0)
			ed.updateEmployee(Integer.parseInt(session.getAttribute("id").toString()), email, "Emp_Email");
		if(password.length() > 0)
			ed.updateEmployee(Integer.parseInt(session.getAttribute("id").toString()), password, "Emp_Password");
		//redirect back to the home page after updating or failure to update.
		response.sendRedirect("home");
	}
}