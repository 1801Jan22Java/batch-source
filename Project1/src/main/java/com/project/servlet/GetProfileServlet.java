package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Reimbursement;
import com.revature.util.ReimburseUtil;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class GetProfileServlet
 */
public class GetProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserUtil uu = new UserUtil();
		String username = "";
		if(session != null ) {
			username = (String) session.getAttribute("username");
		} else {
			response.sendRedirect("login");
		}
		
//		System.out.println(username);

		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		pw.println(gson.toJson(uu.getUser(username)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
