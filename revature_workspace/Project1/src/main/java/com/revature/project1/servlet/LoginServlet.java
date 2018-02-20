package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

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
	//	System.out.println("username entered: " + loginStr + " "+ "password entered: "+passwordStr);
		Employee emp =ed.getEmployeeByCredentials(loginStr,passwordStr);
		//res.getWriter().append("Served at: ").append(req.getContextPath());
	
		res.setContentType("text/html");
		//RequestDispatcher rd= null;
		//rd =req.getRequestDispatcher("views/login.html");
		HttpSession session = req.getSession();
		PrintWriter pw = res.getWriter();
		if(emp!=null) {
			session.setAttribute("username", loginStr);
			session.setAttribute("password", passwordStr);
			session.setAttribute("problem", null);
			if(emp.getIsManager()==1) {
			res.sendRedirect("MasterServlet");
			}
			else {
				res.sendRedirect("EmployeeServlet");
			}
		}
		else {
			
			/*res.setContentType("text/html");
			RequestDispatcher rd = null;
			rd = req.getRequestDispatcher("views/login.html");
			ReimbursementRequestDao rrdi = new ReimbursementRequestDaoImpl();
			rd.include(req, res);*/
			
			pw.println(
					"<html><body style=\"background-color:black; color:white; width:450px;margin-left:auto;margin-right:auto;\">");
			//pw.println("<div>\"<p style=\"background-color:white; width:450px;margin-left:auto;margin-right:auto;\">Invalid credentials. Please try again.</p></div>");
			pw.println("YOU DIDN'T SAY THE MAGIC WORD!");
			pw.println("<img src=\"images\\KOo.gif\" alt=\"Jurassic Park\">");
			pw.println("<a style=\"color:white\" href=\"login\">Back to login page.</a>");
			pw.write("</div></body></html>");
		}
		
		//doGet(req, res);
	}

}
