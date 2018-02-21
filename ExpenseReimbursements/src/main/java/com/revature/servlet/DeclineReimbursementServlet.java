package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class DeclineReimbursementServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User checkUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null && checkUser.getPosition_id() == 2) {
			String uri = req.getPathInfo().substring(1);
			ReimbursementDAO reimburse = new ReimbursementDAOImpl();
			reimburse.resolveReimbursement(checkUser, Integer.parseInt(uri), "declined");
			resp.sendRedirect("/ExpenseReimbursements/managerHome");
		} else {
			resp.sendRedirect("login");
		}
	}
}
