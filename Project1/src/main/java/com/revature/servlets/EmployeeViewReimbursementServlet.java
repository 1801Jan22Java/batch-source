package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;
import com.revature.dao.StatusDao;
import com.revature.dao.StatusDaoSQL;

/**
 * Servlet implementation class EmployeeViewReimbursementServlet
 */
public class EmployeeViewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("greetings");
		System.out.println(request.getQueryString().split("=")[1]);
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			request.getRequestDispatcher("views/EmployeeViewReimbursement.html?" + request.getQueryString().split("=")[1]).forward(request, response);
		}
		else {
			response.sendRedirect("employeehomepage");
		}	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
