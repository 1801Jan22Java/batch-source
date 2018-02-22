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
 * Servlet implementation class NewEmployeeServlet
 */
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/employeecreation.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao ed = new EmployeeDaoImpl();
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		Employee currentUser = ed.getEmployeeByCredentials(name, password);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("views/employeecreation.html");
		rd.include(request, response);
		String lName =request.getParameter("newLastName");
		String fName = request.getParameter("newFirstName");
		String pass = request.getParameter("newPassword");
		String username = request.getParameter("newUsername");
		String email = request.getParameter("newEmail");
		
		System.out.println(fName + " " + lName);
		if(lName.equals("")||fName.equals("")||pass.equals("")||username.equals("")||email.equals("")) {
			pw.println("<script>alert(\"You must fill out all fields\");</script>");
			
		}
		else if (currentUser.getIsManager()!=1) {
			pw.println("<script>alert(\"You are not authorized to create employees.\");</script>");

		} else if (ed.getEmployeeByUsername(username)!=null) {
			pw.println("<script>alert(\"There is already an employee with that username!\");</script>");
			} 
		else {
			//Employee(String firstName, String lastName, String userName,String password,String email, int isManager, Employee manager)
			Employee newEmp = new Employee(fName,lName,username,pass,email,0,currentUser);
			ed.addEmployee(newEmp);
			pw.println("<script>alert(\"Employee added!\");</script>");
		}
		
	}

}
