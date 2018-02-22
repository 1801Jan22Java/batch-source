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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("erwemplogin.html").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Save the user's employee ID for the session
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee employee = ed.getEmpByAcc(username);
		if (username.equals(employee.getAccount())&&(password.equals(employee.getPassword()))) {
			int empID = employee.getEmployeeID();
			session.setAttribute("userID",empID);
			response.sendRedirect("truehome.html");
		}else {
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("erwemplogin.html");
		}
	}

}
