package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/*
 * Servlet used for retrieving current session attributes.
 */

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);	//Defaults to false
		Gson gson = new Gson();
		if (session != null) {
			//Sending a JSON-formatted string
			resp.setContentType("application/json");
			
			//Use the Jackson API for JSON-formatted strings.
			//resp.getWriter().write("{\"email\":\""+session.getAttribute("email")+"\"}");
			resp.getWriter().write(gson.toJson(session));
			
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"email\":null}");
		}
	}

}
