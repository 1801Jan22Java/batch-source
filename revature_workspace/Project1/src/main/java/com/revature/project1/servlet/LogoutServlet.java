package com.revature.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if(session != null) {
			session.invalidate();
			pw.println("<html><body style=\"background-color:black; color:white; width:450px;margin-left:auto;margin-right:auto;\">");
			pw.println("You are successfully logged out");
			pw.println("<a style=\"color:white\" href=\"login\">Come back again!</a>");
			pw.write("</div></body></html>");
		}
		//response.sendRedirect("login");
	}
}


