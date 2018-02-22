package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.ResolvedRequestDaoImpl;

/**
 * Servlet implementation class ManagerReviewPendingResolveServlet
 */
public class ManagerReviewPendingResolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReviewPendingResolveServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {
			ResolvedRequestDaoImpl rrdi = new ResolvedRequestDaoImpl();
			
			ManagerDaoImpl mdi = new ManagerDaoImpl();
			int managerId = Integer.parseInt((String) session.getAttribute("managerid"));

			String selection = request.getParameter("selection");
			int requestId = Integer.parseInt(request.getParameter("requestnumber"));

			System.out.println(managerId);
			System.out.println(selection);
			System.out.println(requestId);

			switch (selection) {
			case "approve":
				rrdi.approvePendingRequest(requestId, managerId);
				break;
			case "deny":
				rrdi.denyPendingRequest(requestId, managerId);;
				break;
			default:
				break;
			}
			
			response.sendRedirect("managerhome");

		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
