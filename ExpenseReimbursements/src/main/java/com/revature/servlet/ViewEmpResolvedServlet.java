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

public class ViewEmpResolvedServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User currentUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null) {
			ReimbursementDAO pending = new ReimbursementDAOImpl();
			List<Reimbursement> pendingList = pending.empViewRevolvedReimbursement(currentUser);
			resp.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String pendingString = om.writeValueAsString(pendingList);
			resp.getWriter().write(pendingString);
		} else {
			resp.sendRedirect("login");
		}
	}

}
