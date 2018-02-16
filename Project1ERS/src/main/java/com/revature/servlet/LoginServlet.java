package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.util.RequestHelper;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check for session, redirect to request page or login page
		HttpSession session = request.getSession(false);
		if(session != null){
			int employeeId = (int) session.getAttribute("employeeId");
			EmployeeDao emd = new EmployeeDaoImpl();
			Employee thisEmployee = emd.getEmployee(employeeId);
			if (thisEmployee != null) {
				response.sendRedirect("requests");
			}
		} else {
			String message = "";
			System.out.println("getParameter = " + request.getParameter("action"));
			String inputAction = request.getParameter("action");
			if (inputAction != null) {
				switch (inputAction) {
				case "logout":
					message = "You Have Logged Out";
					break;
				case "login":
					message = "Please Login";
					break;
				case "email":
					message = "Email Not Found";
					break;
				case "password":
					message = "Incorrect Password";
					break;
				}
			}
			if (message != "") {
				response.setContentType("text/html");
				String javaScript = "<script>window.onload = function () { document.getElementById(\"message\").innerHTML = \"" + message + "\"; }</script>";
				PrintWriter pw = response.getWriter();
				request.getRequestDispatcher("index.html").include(request, response);;
				pw.println(javaScript);
			} else {
				response.sendRedirect("http://localhost:8888/Project1ERS/");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao emd = new EmployeeDaoImpl();
		String inputEmail = request.getParameter("inputEmail");
		if (emd.isAvailable(inputEmail)) {
			response.sendRedirect("logout?action=email");
		} else {
			String inputPassword = request.getParameter("inputPassword");
			Employee thisEmployee = emd.login(inputEmail, inputPassword);
			if (thisEmployee == null) {
				response.sendRedirect("login?action=password");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("employeeId", thisEmployee.getEmployeeId());
				response.sendRedirect("requests");
			}
			
		}
		
		
		
		
	}

}
