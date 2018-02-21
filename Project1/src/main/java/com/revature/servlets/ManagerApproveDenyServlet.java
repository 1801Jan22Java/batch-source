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
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
