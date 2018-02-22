package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class LoginServlet extends HttpServlet{
	
	//Displays the login page for any redirects that happen when a User is not logged in
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("views/index.html").forward(req, resp);
	}
	
	
	//Checks if the form information matches the corresponding database information and will redirect them to the Employee or Manager homepage
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDAO user = new UserDAOImpl();
		User currentUser = user.checkCredentials(username, password);
		
		if(currentUser.getUserName() != null) {
			session.setAttribute("currentUser", currentUser);
			session.setAttribute("problem", null);
			if(currentUser.getPosition_id() == 1) {
				resp.sendRedirect("employeeHome");
			} else {
				resp.sendRedirect("managerHome");
			}
		} else {
			session.setAttribute("problem", "Incorrect credentials");
			resp.sendRedirect("login");
		}
		
		
	}
}
