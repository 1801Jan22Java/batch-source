package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("empID") != null) {
			req.getRequestDispatcher("EmployeePage.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println(req.getSession().toString()+"1");
		if (req.getParameter("request") != null) {
			RequestDaoImpl rdi = new RequestDaoImpl();
			float amount = Float.parseFloat(req.getParameter("amount"));
			String description = req.getParameter("description");
			String filename = "filename";
			Request r = new Request(((int)session.getAttribute("empID")), amount, description, filename);
			try {
				rdi.submit(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		req.getRequestDispatcher("EmployeePage.html").forward(req, resp);
	}
}
