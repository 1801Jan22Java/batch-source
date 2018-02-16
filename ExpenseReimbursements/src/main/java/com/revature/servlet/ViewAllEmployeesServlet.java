package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class ViewAllEmployeesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User checkUser = (User) session.getAttribute("currentUser");
		if(session.getAttribute("currentUser") != null && checkUser.getPosition_id() == 2) {
			UserDAO user = new UserDAOImpl();
			List<User> userList = user.viewAllUsers();
			resp.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String userString = om.writeValueAsString(userList);
			resp.getWriter().write(userString);
			//Use this servlet for the javascript. Have another servlet to get the page.
			
		} else {
			resp.sendRedirect("login");
		}
	}

}
