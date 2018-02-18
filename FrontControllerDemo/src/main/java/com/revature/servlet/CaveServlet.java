package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Cave;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;

/**
 * Servlet implementation class CaveServlet
 */
public class CaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		CaveDao cd = new CaveDaoImpl();
		for (Cave c : cd.getCaves()){
			pw.println("<p>"+c.toString()+"</p>");
		}
		pw.println("<p>what am I?</p>");
		ServletConfig config = getServletConfig();
		pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		pw.println("<p>where are we?</p>");
		pw.println("<p>"+config.getServletContext().getInitParameter("whereAreWe")+"</p>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
