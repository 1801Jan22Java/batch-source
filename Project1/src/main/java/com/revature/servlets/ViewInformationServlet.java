package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;


public class ViewInformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			ReimbursementDao rd = new ReimbursementDaoSQL();
			int id = (int)session.getAttribute("id");
			List<Reimbursement> re = rd.getReimbursementByEmployeeId(id);
			for(Reimbursement r : re) {
				System.out.println(r.toString());
			}
			
		}
		req.getRequestDispatcher("employeehomepage").include(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
