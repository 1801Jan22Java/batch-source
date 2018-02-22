package com.revature.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;

/**
 * Servlet implementation class ImageFetcherServlet
 */
public class ImageFetcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// if a get request is sent to this servlet, it checks to make sure the user is a valid employee, or else it redirects
	// back to the index page. if the user is a valid employee then the servlet will obtain the byte array stored in the dao
	// for the reimbursement based upon the id given from the query string in the URL and pass the byte array to the requester
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("username") != null && session.getAttribute("type") == "employee") {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			int id = Integer.parseInt(request.getQueryString().split("=")[1]);
			System.out.println(id);
			Reimbursement gotReimbursement = rd.getReimbursementByID(id);
			byte [] byteArr = gotReimbursement.getImage();
			
			// make sure the reimbursement pulled from the dao is not null, because if it was null, something went wrong
			// with getting the information out of the dao
			if (gotReimbursement != null) {
				OutputStream out = response.getOutputStream();
				out.write(byteArr);
				out.close();
			}
			
		}
		else {
			response.sendRedirect("/Project1");
		}
	}

	// post should not be called, but if it happens to be called, then just respond with the get fucntionality
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
