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
		RequestDispatcher rd = request.getRequestDispatcher("views/status_page.html");
		String empStr = request.getParameter("employeeid");
		//String empData =req.getParameter("employeeData");
		int empID=Integer.parseInt(empStr);
		EmployeeDao ed = new EmployeeDaoImpl();
		//Employee emp =ed.getEmployeeById(empID);
		String loginStr=request.getParameter("username");
		String passwordStr=request.getParameter("password");
		System.out.println("username entered: " + loginStr + " "+ "password entered: "+passwordStr);
		HttpSession session = request.getSession();
		String name =session.getAttribute("username").toString();
		String password= session.getAttribute("password").toString();
		Employee currentUser =ed.getEmployeeByCredentials(name,password);
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		ReimbursementRequestDao rrdi = new ReimbursementRequestDaoImpl();
		rd.include(request,response);
		pw.println("<div id=\"results\">");
		if(rrdi.getReimbursementRequestsByEmployee(currentUser).size()>0) {
		for (ReimbursementRequest rr : rrdi.getReimbursementRequestsByEmployee(currentUser)){
			/*
			 * <tr><th>Employee</th>
<th>Amount Requested for Reimbursement</th>
<th>Description</th>
<th>Receipt</th>
<th>Pending?</th>
<th>Approved?</th>*/
			pw.println("<tr style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\"><td>"
		+ rr.getEmployee().getFirstName()
		+"</td><td>"+rr.getAmount()
		+"</td><td>Some description"
		+"</td><td>No receit available"
		+"</td><td>"+rr.getPending()
		+"</td><td>"+rr.getApproved()
		+"</td>"+"</tr>");
			//res.getWriter().write(rr.toString());
			
		}
		pw.println("</div>");
		}
		else {
			pw.println("<p>There are no requests for " +currentUser.getFirstName() + " " +currentUser.getLastName()+"</p>");
		}
		//response.sendRedirect("views/status_page.html");
	}

}
