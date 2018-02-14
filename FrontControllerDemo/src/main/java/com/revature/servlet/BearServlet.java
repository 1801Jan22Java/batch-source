package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Bear;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter pw = response.getWriter();
		BearDao bd = new BearDaoImpl();
		for (Bear b : bd.getBears()){
			pw.println("<p>"+b.toString()+"</p>");
		}
		
		pw.println("<p>what am I?</p>");
		ServletConfig config = getServletConfig();
		pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		
		pw.println("<p>where are we?</p>");
		pw.println("<p>"+config.getServletContext().getInitParameter("whereAreWe")+"</p>");
		*/
		BearDao bd = new BearDaoImpl();
		List<Bear> bearList = bd.getBears();
		response.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String bearString = om.writeValueAsString(bearList);
		response.getWriter().write("{\"bears\":" + bearString + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
