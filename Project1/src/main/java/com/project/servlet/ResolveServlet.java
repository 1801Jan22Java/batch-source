package com.project.servlet;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.util.ReimburseUtil;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class ResolveServlet
 */
public class ResolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResolveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getServletPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserUtil uu = new UserUtil();

		int requestid = 0;
		String resolve = "";

		if (session != null) {
			User user = uu.getUser((String) session.getAttribute("username"));
			ReimburseUtil ru = new ReimburseUtil();

			int user_id = user.getUser_id();
			System.out.println(resolve);

			resolve = request.getParameter("resolve");
			requestid = Integer.parseInt(request.getParameter("requestid"));
			if (resolve.equals("approve")) {
				ru.approveRequest(requestid, user_id);
			} else if (resolve.equals("reject")) {
				ru.rejectRequest(requestid, user_id);
			} else {
				System.out.println("not running");
			}
 
			response.sendRedirect("mresolve");

		} else {
			response.sendRedirect("login");
		}
	}

}
