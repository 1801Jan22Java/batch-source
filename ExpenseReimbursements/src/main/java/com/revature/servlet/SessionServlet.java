package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;

public class SessionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session != null) {
			User currUser = (User) session.getAttribute("currentUser");
			resp.setContentType("application/json");
			resp.getWriter().write("{\"firstName\": \"" + currUser.getFirstName() + "\", "
									+ "\"lastName\": \"" + currUser.getLastName() + "\", "
									+ "\"userId\": \"" + currUser.getUserId() + "\"}");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"firstname\":null\"}");
		}
	}
}
