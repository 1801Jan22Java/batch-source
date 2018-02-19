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

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/employeeinfo.html");
		String fName = request.getParameter("firstNameChange");
		String lName = request.getParameter("lastNameChange");
		String email = request.getParameter("emailChange");
		HttpSession sess = request.getSession();
		String username =sess.getAttribute("username").toString();
		System.out.println(username);
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp = ed.getEmployeeByUsername(username);
		if(!fName.equals("")) {
			System.out.println("Value entered");
			ed.updateFirstName(emp, fName);
			
		}
		else {
			System.out.println("Blank");
		}
		if(!lName.equals("")) {
			System.out.println("Value entered");
			ed.updateLastName(emp, lName);
		}
		else {
			System.out.println("Blank");
		}
		if(!email.equals("")) {
			System.out.println("Value entered");
			ed.updateEmail(emp, email);
		}
		else {
			System.out.println("Blank");
		}
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(email);
		PrintWriter pw = response.getWriter();
		pw.println(
				"<html><body style=\"background-color:black; color:white; width:450px;margin-left:auto;margin-right:auto;\">");
		pw.println("Update successful!");
		pw.println("<a style=\"color:white\" href=\"EmployeeInfoServlet\">Back to your information.</a>");
		pw.write("</div></body></html>");
	}

}
