package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class EmployeeViewPendingRequestsServlet
 */
public class EmployeeViewPendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeViewPendingRequestsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if( session != null && session.getAttribute("username") != null){
			//request.getRequestDispatcher("/views/EmployeeViewPendingRequests.html").forward(request, response);
			
		response.setContentType("text/json");
		RequestDaoImpl rdi = new RequestDaoImpl();
		List<Request> requestList = rdi.getAllRequests();
		//Employee employee = (Employee)session.getAttribute("employee");
		//System.out.println(employee);
		//requestList = rdi.getPendingRequestsByEmployeeId(employee.getEmployeeId());
		
		int employeeid = Integer.parseInt((String)session.getAttribute("employeeid"));
		requestList = rdi.getPendingRequestsByEmployeeId(employeeid);
		
		Gson gson = new Gson();
		//String jsonRequests = gson.toJson(requestList);
		response.getWriter().println(gson.toJson(requestList));
		
		} else {
			response.sendRedirect("/views/Login.html");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
