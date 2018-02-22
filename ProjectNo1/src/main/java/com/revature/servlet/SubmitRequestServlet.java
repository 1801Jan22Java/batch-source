package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

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

public class SubmitRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -505880285822944832L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (Boolean)session.getAttribute("is_manager");
		if(manager) {
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getAllRequests();
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			pw.write(jsonValue);
		}else {
			int id  = (Integer)session.getAttribute("EmployeeID");
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getAllRequests();
			requests = rdi.getEmployeeRequests(id);
			// get list of all requests, then refine list by employee ID
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			pw.write(jsonValue);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer amount = Integer.parseInt(req.getParameter("r_amount"));
		String message = req.getParameter("message");
		RequestDaoImpl rdi = new RequestDaoImpl();
		System.out.println("Added new request, amount = " + amount);
		rdi.addRequest(new Request((Integer) session.getAttribute("employeeID"), amount.doubleValue(), message, "PENDING"));
			
	}

	

}
