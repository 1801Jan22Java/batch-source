package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Bear;
import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;

public class BearServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*PrintWriter pw = resp.getWriter();
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
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String bearString = om.writeValueAsString(bearList);
		resp.getWriter().write("{\"bears\":"+bearString+"}");
	}

}
