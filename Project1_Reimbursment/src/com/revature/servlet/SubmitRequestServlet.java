package com.revature.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

public class SubmitRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -505880285822944832L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (boolean)session.getAttribute("is_manager");
		if(manager)
			req.getRequestDispatcher("submit_manager_requests.html").forward(req, resp);
		else
			req.getRequestDispatcher("new_request.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer amount = Integer.parseInt(req.getParameter("r_amount"));
		String message = req.getParameter("message");
		RequestDaoImpl rdi = new RequestDaoImpl();
		rdi.addRequest(new Request((int) session.getAttribute("employeeID"), amount, message, "PENDING"));
			
	}

	

}
