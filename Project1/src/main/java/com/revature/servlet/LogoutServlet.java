package com.revature.servlet;

import java.io.File;
import java.io.IOException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		// Delete all of our temp files
		File folder = new File(this.getServletContext().getRealPath("/"));
		File fileArr[] = folder.listFiles();
		for (int i = 0; i < fileArr.length; i++) {
		    File pes = fileArr[i];
		    String name = pes.getName();
		    if (name.endsWith(".txt") || name.endsWith(".jpg")) {
		    	fileArr[i].delete();
		    }
		}
		if(session != null){
			session.invalidate();
		}
		resp.sendRedirect("Logout.html");
	}

}
