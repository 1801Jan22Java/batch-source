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
		boolean manager = ((String)session.getAttribute("is_manager") == "true");
		if(manager) {
			req.getRequestDispatcher("./new_request");
		}else {
			req.getRequestDispatcher("./submit_manager_request").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer amount = Integer.parseInt(req.getParameter("r_amount"));
		String message = req.getParameter("message");
		RequestDaoImpl rdi = new RequestDaoImpl();
		
		rdi.addRequest(new Request(((Integer) req.getSession().getAttribute("employeeID")), amount.doubleValue(), message, "PENDING"));
		if(((String)req.getSession().getAttribute("is_manager") == "true")) {
			resp.sendRedirect("./manager_home");
		}
		else
			resp.sendRedirect("./employee_home");
	}

	

}
