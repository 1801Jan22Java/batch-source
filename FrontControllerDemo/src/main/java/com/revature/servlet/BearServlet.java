package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*PrintWriter pw = resp.getWriter();
		
		//Simple getter method, so we don't need an intermediary here
		BearDao bd = new BearDaoImpl();
		for(Bear b : bd.getBears()) {
			pw.println("<p>"+b.toString()+"</p>");
		}
		
		pw.println("<p>What am I?</p>");
		ServletConfig config = getServletConfig();
		
		//The init-param param-name in web.xml
		//Servlet Config available to one
		pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");	
		pw.println("<p>Where are we?</p>");
		ServletContext context = config.getServletContext();
		
		//The init-param param-name in web.xml
		//Servlet Context accessible to every servlet
		pw.println("<p>"+context.getInitParameter("whereAreWe")+"</p>");  */
		
		BearDao bd = new BearDaoImpl();
		List<Bear> bearList = bd.getBears();
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
		String bearString = om.writeValueAsString(bearList);
		resp.getWriter().write("{\"bears\":"+bearString+"}");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
