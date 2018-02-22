package com.revature.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;


@MultipartConfig
public class ProcessRequestServlet extends HttpServlet {
	
	// Saving the uploaded image to the database
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("currentUser") != null) {
			User currentUser = (User) session.getAttribute("currentUser");
			Part fileImage = req.getPart("uploadFile");
			ReimbursementDAO addReimbursement = new ReimbursementDAOImpl();
			addReimbursement.submitReimbursement(currentUser, fileImage.getInputStream(), Double.parseDouble(req.getParameter("amount")));
			resp.sendRedirect("/ExpenseReimbursements/submitRequest");
		}
		
	}
}
