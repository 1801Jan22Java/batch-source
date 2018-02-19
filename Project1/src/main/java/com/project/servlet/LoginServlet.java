package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserUtil uu = new UserUtil();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(uu.login(username, password)) {
			
			User user = uu.getUser(username);
			session.setAttribute("username", username);
			session.setAttribute("position", user.getPosition_id());
			session.setAttribute("problem", null);
			if(user.getPosition_id()==2) {
				resp.sendRedirect("mprofile");
			} else if(user.getPosition_id()==1){
				resp.sendRedirect("profile");
			}
			
		} else {
			//pw.println("nope");
			//pw.println("<a href=\"Index.html\">Go back</a>");
			session.setAttribute("problem", "Incorrect password");
			resp.sendRedirect("login");
		}
	}
}
