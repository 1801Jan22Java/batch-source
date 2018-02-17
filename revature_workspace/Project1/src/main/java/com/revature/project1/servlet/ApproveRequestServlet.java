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
import com.revature.project1.dao.ReimbursementRequestDaoImpl;

/**
 * Servlet implementation class ApproveRequestServlet
 */
public class ApproveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqIDStr = request.getParameter("id");
		int reqID = Integer.parseInt(reqIDStr);
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();
		String password = session.getAttribute("password").toString();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee currentUser = edi.getEmployeeByCredentials(name, password);
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
		ReimbursementRequest rr =rdi.getReimbursementRequestById(reqID);
		rdi.approveReimbursementRequest(reqID, currentUser);
		request.getRequestDispatcher("approval").forward(request, response);
		//System.out.println(request.getParameter("approverequest"));
		//System.out.println("Hello");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String empStr = request.getParameter("employeeid");
		// String empData =req.getParameter("employeeData");
		//System.out.println("ApprovalRequestServlet reached");
		response.sendRedirect("/Project1/approval");
	
	}

}
