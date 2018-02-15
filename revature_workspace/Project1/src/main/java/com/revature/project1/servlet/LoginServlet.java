package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("views/login.html").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		EmployeeDao ed = new EmployeeDaoImpl();
		String loginStr=req.getParameter("username");
		String passwordStr=req.getParameter("password");
		System.out.println("username entered: " + loginStr + " "+ "password entered: "+passwordStr);
		Employee emp =ed.getEmployeeByCredentials(loginStr,passwordStr);
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd= null;
		rd =req.getRequestDispatcher("views/login.html");
		if(emp!=null) {
			res.sendRedirect("views/main.html");
		}
		else {
			
		}
		
		//doGet(req, res);
	}

}
