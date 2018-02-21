package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Register post");
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		//Check to see if email is valid
		if(!dao.isEmailRegistered(email)) {
			//Match passwords
			if(password1.equals(password2)) {
				dao.register(email, password1);
				response.sendRedirect("home.html");
			}
			else {
				//TODO::Throw better error
				PrintWriter pw = response.getWriter();
				pw.println("Passwords do not match!");
				session.setAttribute("problem", "password match");
			}
			
		}
		else {
			//TODO::Throw better error
			PrintWriter pw = response.getWriter();
			pw.println("Email already in use!");
			session.setAttribute("problem", "email in use");
		}
	}

}
