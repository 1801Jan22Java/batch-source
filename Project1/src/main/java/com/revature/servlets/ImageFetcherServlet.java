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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("get within image fetcher");
		if (session != null && session.getAttribute("username") != null) {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			int id = Integer.parseInt(request.getQueryString().split("=")[1]);
			System.out.println(id);
			Reimbursement gotReimbursement = rd.getReimbursementByID(id);
			byte [] byteArr = gotReimbursement.getImage();
			System.out.println(byteArr.length);
			if (gotReimbursement != null) {
				OutputStream out = response.getOutputStream();
				out.write(byteArr);
				out.close();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
