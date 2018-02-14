package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Cave;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;


public class CaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		//Simple getter method, so we don't need an intermediary here
		CaveDao cd = new CaveDaoImpl();
		for(Cave c : cd.getCaves()) {
			pw.println("<p>"+c.toString()+"</p>");
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
		pw.println("<p>"+context.getInitParameter("whereAreWe")+"</p>");
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
