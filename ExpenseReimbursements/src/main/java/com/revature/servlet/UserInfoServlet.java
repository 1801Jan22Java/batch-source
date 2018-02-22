package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class UserInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User currentUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null) {
			UserDAO user = new UserDAOImpl();
			User userInfo = user.getUserById(currentUser.getUserId());
			resp.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String userInfoString = om.writeValueAsString(userInfo);
			resp.getWriter().write(userInfoString);
		}
	}
}
