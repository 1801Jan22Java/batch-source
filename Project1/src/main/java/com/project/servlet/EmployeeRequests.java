package com.project.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.dao.ReimburseOracle;
import com.revature.dao.UserOracle;
import com.revature.util.ReimburseUtil;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class EmployeeRequests
 */
public class EmployeeRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReimburseOracle ro = new ReimburseOracle();
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
		pw.println(gson.toJson(ro.viewAllRequestsEmp(username)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
