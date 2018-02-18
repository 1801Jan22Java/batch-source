package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.CompletedRequest;
import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class ViewCompletedRequestsServlet
 */
public class ViewCompletedRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		
		List<Request> resolvedRequests = rdi.readAllResolvedRequests();
		List<CompletedRequest> completedRequests = new ArrayList<CompletedRequest>();
		for(Request r : resolvedRequests) {
			completedRequests.add(new CompletedRequest(r.getRequestID()));
		}
		
		//Parse the information into JSON format
		Gson gson = new Gson();
		String parsedLogs = gson.toJson(completedRequests);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("ISO-8859-1");
//		System.out.println(parsedLogs);
		resp.getWriter().write(parsedLogs); 
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
