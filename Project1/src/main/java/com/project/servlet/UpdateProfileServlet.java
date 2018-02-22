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
import com.revature.beans.User;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getServletPath());
//		System.out.println(username);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserUtil uu = new UserUtil();
		int id = 0;
		String firstname = "";
		String lastname = "";
		String password = "";
		if(session != null ) {
			User user = uu.getUser((String)session.getAttribute("username"));
			id = user.getUser_id();
			firstname = (String) request.getParameter("firstname");
			lastname = (String) request.getParameter("lastname");
			password = (String) request.getParameter("password");
			if(user.getPosition_id()==1){
				uu.updateUser(id, firstname, lastname, password);
				
				response.sendRedirect("profile");
			} else if(user.getPosition_id()==2) {
				uu.updateUser(id, firstname, lastname, password);
				response.sendRedirect("mprofile");
			}
		} else {
			response.sendRedirect("login");
		}
	}

}
