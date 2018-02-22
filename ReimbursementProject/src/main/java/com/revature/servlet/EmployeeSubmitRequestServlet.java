package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class EmployeeSubmitRequestServlet
 */
public class EmployeeSubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmitRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username") != null){
			int employeeId = Integer.parseInt((String) session.getAttribute("employeeid"));
			double requestAmount = Double.parseDouble(request.getParameter("amount"));
			String requestComment = request.getParameter("comment");
			RequestDaoImpl rdi = new RequestDaoImpl();
			rdi.submitNewRequest(employeeId, requestAmount, requestComment);
			
			response.sendRedirect("employeehome");
		} else {
			response.sendRedirect("login");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
