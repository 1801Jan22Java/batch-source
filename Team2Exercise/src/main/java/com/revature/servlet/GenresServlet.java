package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GenresServlet
 */

public class GenresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenresServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		pw.println("Hello " + session.getAttribute("username"));
		req.getRequestDispatcher("genres.html").include(req, resp);
		
		String[] genre = {"action", "comedy", "drama"};
		
//		resp.setContentType("application/json");
//		ObjectMapper om = new ObjectMapper();
//		String genreString = om.writeValueAsString(genre);
//		resp.getWriter().write("{\"bears\":" + genreString + "}");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		pw.println("Hello" + session.getAttribute("username"));
		req.getRequestDispatcher("genres.html").include(req, resp);*/
	}
	

}
