package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("currentUser") != null) {
			User currentUser = (User) session.getAttribute("currentUser");
			String firstName = currentUser.getFirstName();
			String lastName = currentUser.getLastName();
			String username = currentUser.getUserName();
			String password = currentUser.getPassword();
			String email = currentUser.getEmail();
			if(req.getParameter("firstName") != "") {
				firstName = req.getParameter("firstName");
			}
			if(req.getParameter("lastName") != "") {
				lastName = req.getParameter("lastName");
			}
			if(req.getParameter("username") != "") {
				username = req.getParameter("username");
			}
			if(req.getParameter("password") != "") {
				password = req.getParameter("password");
			}
			if(req.getParameter("email") != "") {
				email = req.getParameter("email");
			}
			UserDAO updateUser = new UserDAOImpl();
			updateUser.updatePersonalInfo(currentUser, firstName, lastName, email, username, password);
		}
		resp.sendRedirect("/ExpenseReimbursements/viewEmpInfo");
	}
}
