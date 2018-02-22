package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;

/**
 * Servlet implementation class ManagerApproveDenyServlet
 */
public class ManagerApproveDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	// if a get request is called on this servlet first check if the user is a valid manager. if the user is not a valid
	// manager, redirect the user to the manager login. if the user is valid then update the reimbursement using the id
	// and status from the queryString in the URL. redirect the request back to the page to show the updated status
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "manager") {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			int id = Integer.parseInt(request.getQueryString().split("&")[0].split("=")[1]);
			int status = Integer.parseInt(request.getQueryString().split("&")[1].split("=")[1]);
			rd.updateStatus(id, (int)session.getAttribute("id"), status);
			response.sendRedirect("managerviewreimbursement?val=" + id);
		}
		else {
			response.sendRedirect("managerhomepage");
		}
	}
	
	// if a post request is called, then just respond with the get request behavior
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
