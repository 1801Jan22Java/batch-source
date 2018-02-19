package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class ViewEmployeesServlet
 */
public class ViewEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee currentUser = edi.getEmployeeByCredentials(name, password);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd =  request.getRequestDispatcher("views/employees.html");
		
		rd.include(request, response);
		pw.println("<div id=\"results\">");
		
		if(currentUser.getIsManager()==1) {
			edi.getEmployeesByManager(currentUser);
		}
		
		if (!(currentUser.getIsManager()==1)) {
		pw.println("<p style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\">You do not seem to be managing anyone</p>");
		} else if (edi.getEmployeesByManager(currentUser).size() <= 0) {
			pw.println("<p>You do not seem to be managing anyone</p>");
		} else {
			pw.println("<table class=\"requestTable\"><tr><th>Employee First Name</th><th>"
					+ "Employee Last Name</th>" + "<th>Employee Username</th>" + "<th>Employee Email</th>"
					+ "<th>Employee ID</th>" + "<th>Is Manager?</th>");
			ServletConfig config = getServletConfig();
			for (Employee e : edi.getEmployeesByManager(currentUser)) {
				pw.println(
						"<tr style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\"><td>"
								+ e.getFirstName()+ "</td><td>"
								+ e.getLastName() + "</td><td>"+e.getUserName()+"</td><td>"+e.getEmail()
								+ "</td><td>" + e.getEmployeeID() + "</td><td>" + e.getIsManager()
								+ "</td></tr>");
			}
			pw.println("</table></div>");}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
