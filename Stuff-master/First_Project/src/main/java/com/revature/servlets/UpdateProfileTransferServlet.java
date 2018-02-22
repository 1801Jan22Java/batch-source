package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;


public class UpdateProfileTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateProfileTransferServlet() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("UpdateProfile.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		System.out.println(sess.getAttribute("Passwo")+" "+sess.getAttribute("Username") );
		response.getWriter().write("{things:[{\"Password\":\""+emp.getEmployee_ID()+"\"},username:\""+sess.getAttribute("Username")+"\"},{\"Email\":\""+sess.getAttribute("Email")+"\"}");
	
		
	}

}
