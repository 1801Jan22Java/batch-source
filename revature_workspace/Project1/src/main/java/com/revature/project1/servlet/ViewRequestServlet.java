package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.beans.ReimbursementRequest;
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class ViewRequestServlet
 */
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/status_page.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empStr = request.getParameter("employeeid");
		//String empData =req.getParameter("employeeData");
		int empID=Integer.parseInt(empStr);
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp =ed.getEmployeeById(empID);
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("views/status_page.html");
		ReimbursementRequestDao rrdi = new ReimbursementRequestDaoImpl();
		rd.include(request,response);
		pw.println("<div id=\"results\">");
		if(rrdi.getReimbursementRequestsByEmployee(emp).size()>0) {
		for (ReimbursementRequest rr : rrdi.getReimbursementRequestsByEmployee(emp)){
			pw.println("<p style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\">"+rr.toString()+"</p>");
			//res.getWriter().write(rr.toString());
			
		}
		pw.println("</div>");
		}
		else {
			pw.println("<p>There is no employee with ID " +empStr+"</p>");
		}
		//response.sendRedirect("views/status_page.html");
	}

}
