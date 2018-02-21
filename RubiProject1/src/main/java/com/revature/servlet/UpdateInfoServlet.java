package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Staff;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

/**
 * String lastName, String firstName, String email, String password, String username, int employeeId
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateInfoServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			resp.setContentType("text/html");
			String sessEmail = session.getAttribute("email").toString();
			StaffDAO updateStaff = new StaffDAOImpl();
			Staff currStaff = updateStaff.getStaff(sessEmail);
			
			String lastName = req.getParameter("lastName");
			String firstName = req.getParameter("firstName");
			/* This email is not the same as session email, this the email from the form. 
			 * Unless user provides the same email.
			 */
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String username = req.getParameter("username");
			int employeeId = currStaff.getEmployeeId();
			
			int updatingInfo = updateStaff.updateInfo(lastName, firstName, email, password, username, employeeId);
			if(updatingInfo == 1) {
				System.out.println("Updated staff information success!");
			}
			resp.sendRedirect("employeeHome");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"message\": session in UpdateInfoServlet is NULL}");
		}

	}
}
