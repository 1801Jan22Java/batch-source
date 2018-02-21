package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{

	private static final long serialVersionUID = -1319793763433572026L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("sessionServ get");
		HttpSession session = req.getSession();
		if(session != null) {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\":\""+session.getAttribute("username")+"\""
					+ ", \"manager\":\"" + session.getAttribute("manager") + "\"}");
		}
		else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\": null}");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
