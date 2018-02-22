package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.ResolvedRequest;
import com.revature.dao.ResolvedRequestDaoImpl;

/**
 * Servlet implementation class ManagerReviewResolvedServlet
 */
public class ManagerReviewResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReviewResolvedServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("username") != null) {
			response.setContentType("text/json");
			ResolvedRequestDaoImpl rrdi = new ResolvedRequestDaoImpl();
			List<ResolvedRequest> resolvedRequestList = null;

			resolvedRequestList = rrdi.getAllResolvedRequests();

			if (resolvedRequestList != null) {
				Gson gson = new Gson();
				response.getWriter().println(gson.toJson(resolvedRequestList));
			}

		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
