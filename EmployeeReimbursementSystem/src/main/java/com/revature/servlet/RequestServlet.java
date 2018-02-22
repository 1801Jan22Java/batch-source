package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Grabs all user requests from the database
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		RequestDao rd = new RequestDaoImpl();
		HttpSession session = request.getSession(false);
		
		int empzID =  (Integer) session.getAttribute("userID");
		//String empzID = "1021";
		System.out.println(empzID);
		//if (empzID!= null) {
			//int empsID = Integer.parseInt(empzID);	
			
			ArrayList<Request> reqs = new ArrayList<Request>();
			reqs = rd.getRequestsByEmployee(empzID);
			
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
		String reqString = om.writeValueAsString(reqs);
			pw.write(reqString);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
