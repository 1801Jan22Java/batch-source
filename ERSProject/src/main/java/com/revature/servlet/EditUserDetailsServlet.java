package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;

public class EditUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("post user mod");
		HttpSession session = request.getSession();
		
		if(session != null) {
			String email = (String) session.getAttribute("username");
			
			if(email != null) {
				EmployeeDao dao = new EmployeeDaoImpl();
				
				String newEmail = request.getParameter("email");
				
				if(!dao.isEmailRegistered(newEmail)) {
					
					
					
					dao.changeEmail(email, newEmail);
					
					session.invalidate();
					response.sendRedirect("home.html");
					return;
				}
			}
		}
		
		response.sendRedirect("account.html");
	}

}
