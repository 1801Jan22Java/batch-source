package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ViewAllPendingRequestsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User checkUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null && checkUser.getPosition_id() == 2) {
			ReimbursementDAO reimburse = new ReimbursementDAOImpl();
			List<Reimbursement> reimbursementList = reimburse.viewAllPendingRequests(checkUser);
			resp.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String userString = om.writeValueAsString(reimbursementList);
			resp.getWriter().write(userString);
			//Use this servlet for the javascript. Have another servlet to get the page.
			
		} else {
			resp.sendRedirect("login");
		}
	}
}
