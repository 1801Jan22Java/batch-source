package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.*;
import com.revature.dao.*;

/**
 * Servlet implementation class ViewReimbursementServlet
 */
public class ManagerViewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// if a get request is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, forward the user to the requested html page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("greetings");
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			request.getRequestDispatcher("views/ManagerViewReimbursement.html").forward(request, response);
		}
		else {
			response.sendRedirect("managerhomepage");
		}	
	}

	// if a post is called make sure the user is a valid manager. if the user is not a valid manager, then redirect the
	// manager to the manager login. if the user is a valid manager, gather information from the dao pertaining to the 
	// reimbursement using the querystring passing in from the URL. the information is packaged in JSON format
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			StatusDao sd = new StatusDaoSQL();
			response.setContentType("application/json");
			System.out.println(request.getQueryString());
			int id = Integer.parseInt(request.getQueryString().split("=")[1]);
			Reimbursement requestedReimbursement = rd.getReimbursementByID(id);
			if (requestedReimbursement != null) {
				String JSONobj = "";
	
				JSONobj += "{\"status\" : \"" + sd.getStatusById(requestedReimbursement.getStatus())+ "\"," ;
				if(requestedReimbursement.getManagerId() == 0) {
					JSONobj +=  "\"manId\" : \" N/A\"," ;
				}
				else {
					JSONobj +=  "\"manId\" : \" " + requestedReimbursement.getManagerId() + "\"," ;
				}
				JSONobj +=  "\"value\" : \"" + requestedReimbursement.getReimbursementValue() + "\"," ;
				JSONobj +=  "\"remId\" : \"" + requestedReimbursement.getReimbursementId() + "\"}" ;
				response.getWriter().write(JSONobj);
				System.out.println(JSONobj);
	
			}
		}
	}

}
