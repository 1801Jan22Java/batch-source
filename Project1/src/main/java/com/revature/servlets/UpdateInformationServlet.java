package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.EmployeeInformation;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeInformationDao;
import com.revature.dao.EmployeeInformationDaoSQL;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoSQL;

public class UpdateInformationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			req.getRequestDispatcher("views/employeeupdateinformation.html").forward(req, resp);
		}
		else {
			resp.sendRedirect("employeelogin");
		}
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String email = req.getParameter("email");
			String addrs = req.getParameter("address");
			EmployeeInformationDao ed = new EmployeeInformationDaoSQL();
			System.out.println("id is " + (int)session.getAttribute("id"));
			EmployeeInformation employeeInformation = ed.getEmployeeInformationByID((int)session.getAttribute("id"));
			if (employeeInformation != null) {
				System.out.println("not null");
				ed.updateInformation(employeeInformation.getEmployeeInformationId(), email, fname, lname, addrs);
				req.getRequestDispatcher("employeehomepage").forward(req,resp);
			}
			else {
				resp.sendRedirect("updateinfo");
			}
		}
		else {
			resp.sendRedirect("employeelogin");
		}
	}

}
