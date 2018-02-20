package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;

@MultipartConfig
public class SubmitReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("views/submitreimbursement.html").forward(request, response);
		}
		else {
			response.sendRedirect("employeelogin");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			ServletInputStream in = request.getInputStream();
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			String query = request.getQueryString();
			Double reimbursementValue = Double.parseDouble(query.split("=")[1]);
			ReimbursementDao rd = new ReimbursementDaoSQL();
			if (in.available() > 0) {
				int c = 0;
				int count = 0;
				while((c=in.read()) != -1) {
					bao.write(c);
					count += 1;
				}
				byte [] byteArr = bao.toByteArray();
				rd.submitReimbursement((int)session.getAttribute("id"), reimbursementValue,byteArr);
			}
		}
		else {
			response.sendRedirect("employeelogin");
		}
	}

}
