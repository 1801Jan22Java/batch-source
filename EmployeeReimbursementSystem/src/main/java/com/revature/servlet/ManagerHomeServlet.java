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
 * Servlet implementation class ManagerHomeServlet
 */
public class ManagerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Show's the manager incomplete requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		RequestDao rd = new RequestDaoImpl();
		//HttpSession session = request.getSession(false);
		ArrayList<Request>	requests = rd.getIncompleteRequests();
			
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String reqsString = om.writeValueAsString(requests);
			pw.write(reqsString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
