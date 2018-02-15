package com.revature.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ImageServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("page3.html").forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String [] imageArray = new String[10];
		imageArray[0]="/images/aCkDw.jpg";
		imageArray[1]="/image/candy-cane-origin.jpg";
		imageArray[2]="/image/dsc_0074.jpg";
		imageArray[3]="/image/giphy.gif";
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		//String imageStr = req.getParameter("imageInput");
		String imageStr = imageArray[(int)Math.floor(Math.random()*4)];
		session.setAttribute("imageInput", imageStr);
		//res.sendRedirect("page3.html");

		
		
	}
}
