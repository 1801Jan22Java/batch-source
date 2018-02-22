package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.util.InvalidActionException;

public class ViewRequestsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622166310225164697L;

	public ViewRequestsServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (String) session.getAttribute("is_manager") == "true";
		if (manager) {
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getAllRequests();
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			pw.write(jsonValue);
		} else {
			int id = ((Integer) session.getAttribute("employeeID"));
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getEmployeeRequests(id);
			for (Request r : requests) {
				System.out.println("Request id is : " + r.getRequestID());
			}
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			//System.out.println("JSON IS : " + jsonValue);
			pw.write(jsonValue);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String approved = req.getParameter("ResolveRadio");
		System.out.println(approved);
		if(approved == null){
			approved = "REJECTED";
			// by default
		}
		int rid =  Integer.parseInt(req.getParameter("requestID"));
		String reply =  req.getParameter("replyTxt");
		int managerID = (Integer) req.getSession().getAttribute("employeeID");
		// get the relevant fields - requestID, manager's ID, reply, and new status
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee billy = edi.getEmployeeById(managerID);
		RequestDao rdi = new RequestDaoImpl();
		try {
			rdi.resolveRequest((new Request(rid, managerID, reply, approved)), billy, reply);
		} catch (InvalidActionException e) {
			// In the interest of time, I'll actually do something with the exception later
			e.printStackTrace();
		}
		System.out.println("Resolved a request");
		resp.sendRedirect("./manager_home");
		
	}

}
