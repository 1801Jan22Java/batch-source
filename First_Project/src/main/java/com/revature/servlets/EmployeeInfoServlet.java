package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;

public class EmployeeInfoServlet extends HttpServlet {
	EmployeeDaoImpl em = new EmployeeDaoImpl();
	private static final long serialVersionUID = 1L;

	public EmployeeInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			RequestDaoImpl info = new RequestDaoImpl();
			System.out.println(request.getSession().getAttribute("Employee_Id").toString());
			String Reinbursment_Object = info.getPendingEmployeeReinbursments(Integer.parseInt(request.getSession().getAttribute("Employee_Id").toString())).toString();
			response.setContentType("text/html");
			response.getWriter().write(Reinbursment_Object);
		}else {
			response.sendRedirect("login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
