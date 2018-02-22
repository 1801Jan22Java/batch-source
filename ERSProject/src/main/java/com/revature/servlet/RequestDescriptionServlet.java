package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class RequestDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("desc get");
		HttpSession session = request.getSession();
		
		if(session != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			RequestDao reqDao = new RequestDaoImpl();
			Request req = reqDao.GetRequest(id);
			
			if(req != null ) {
				
				response.setContentType("text/html");
				response.getWriter().write(req.getDescription());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
