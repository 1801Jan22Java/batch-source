package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class ViewEmployeeRequestsServlet
 */
public class ViewEmployeeRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		
		ArrayList<Request> arrReq = rdi.readAllRequests(Integer.valueOf(session.getAttribute("IDToView").toString()));
		
		Gson gson = new Gson();
		
		String parsedRequests = gson.toJson(arrReq);

		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");
		resp.getWriter().write(parsedRequests);
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
