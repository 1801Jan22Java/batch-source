package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Bear;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class BearServlet
 */
public class BearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// PrintWriter pw = res.getWriter();
		// BearDao bd = new BearDaoImpl();
		// for(Bear b: bd.getBears()) {
		// pw.println("<p>"+b.toString()+"</p>");
		// }
		//
		// pw.println("<p>what am I</p>");
		// ServletConfig config = getServletConfig();
		// pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		// pw.println("<p>where we</p>");
		// pw.println("<p>"+config.getServletContext().getInitParameter("whereAreWe")+"</p>");
		BearDao bd = new BearDaoImpl();
		
		List<Bear> bearList = bd.getBears();
		
		res.setContentType("application/json");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
