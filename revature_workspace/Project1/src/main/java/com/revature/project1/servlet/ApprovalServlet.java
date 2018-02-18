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
import com.revature.project1.dao.EmployeeDao;
import com.revature.project1.dao.EmployeeDaoImpl;
import com.revature.project1.dao.ReimbursementRequestDao;
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class ApprovalServlet
 */
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApprovalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("views/approvalpage.html").forward(req, res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String empStr = req.getParameter("employeeid");
		// String empData =req.getParameter("employeeData");
		int empID = Integer.parseInt(empStr);
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee emp = ed.getEmployeeById(empID);
		// res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("views/approvalpage.html");
		ReimbursementRequestDao rrdi = new ReimbursementRequestDaoImpl();
		rd.include(req, res);
		pw.println("<div id=\"results\">");
		HttpSession session = req.getSession();
		String name = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		Employee currentUser = ed.getEmployeeByCredentials(name, password);
		System.out.println(name + "  is currently logged in");
		if (!emp.getManager().getUserName().equals(currentUser.getUserName())) {
			pw.println(
					"<p style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\">You are not authorized to approve these requests</p>");
		} else if (rrdi.getReimbursementRequestsByEmployee(emp).size() <= 0) {
			pw.println("<p>There is no employee with ID " + empStr + "</p>");
		} else {
			pw.println("<table class=\"requestTable\"><tr><th>Employee</th><th>"
					+ "Amount Requested for Reimbursement</th>" + "<th>Description</th>" + "<th>Receipt</th>"
					+ "<th>Pending Status</th>" + "<th>Approval Status</th>" + "<th>Approve?</th><th>Deny?</th>");
			ServletConfig config = getServletConfig();
			for (ReimbursementRequest rr : rrdi.getReimbursementRequestsByEmployee(emp)) {
				pw.println(
						"<tr style=\"background-color:powderblue; width:450px;margin-left:auto;margin-right:auto;\"><td>"
								+ rr.getEmployee().getFirstName() + " " + rr.getEmployee().getLastName() + "</td><td>"
								+ rr.getAmount() + "</td><td>"+rr.getDescription()+"</td><td><a href="+rr.getExtent()
								+ ">View receipt</a></td><td>" + rr.getPending() + "</td><td>" + rr.getApproved()
								+ "</td>"+
								"<td><a href='/Project1/confirm?id="+rr.getRequestID()+"'>Approve</a></td>"
								+"<td><a href='/Project1/deny?id="+rr.getRequestID()+"'>Deny</a></td>" + "</tr>");
			}
			pw.println("</table></div>");
		
		//	System.out.println(req.getParameter("approverequest"));
			
		}
		
		//System.out.println(getServletInfo());
	//	System.out.println(req.getParameter("approverequest"));

	}
}
