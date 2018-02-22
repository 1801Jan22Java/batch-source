package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class AllRequestsServlet
 */
public class AllRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //Grabs all Employees from database and sends them in JSON
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		RequestDao rd = new RequestDaoImpl();
		//HttpSession session = request.getSession(false);		
			ArrayList<Request> requests = rd.getCompleteRequests();
			ArrayList<Request> incReqs = rd.getIncompleteRequests();
			requests.addAll(incReqs);
				
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String empString = om.writeValueAsString(requests);
			pw.write(empString);
			System.out.println("yay");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
