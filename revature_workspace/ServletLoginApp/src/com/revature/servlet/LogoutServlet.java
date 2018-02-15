package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Base.html").include(req, resp);
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		pw.println("You are successfully logged out");
		pw.println("<a href=\"Index.html\">Go back</a>");
		pw.write("</div></body></html>");
	}
	
}
