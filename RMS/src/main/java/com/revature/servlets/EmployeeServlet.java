package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("employeeID") != null) {
			req.getRequestDispatcher("EmployeePage.html").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("request") != null) {
			RequestDaoImpl rdi = new RequestDaoImpl();
			float amount = Float.parseFloat(req.getParameter("amount"));
			String description = req.getParameter("description");
			String filename = "filename";
			Request r = new Request((int)session.getAttribute("employeeID"), amount, description, filename);
			try {
				rdi.submit(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (req.getParameter("update") != null) {
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String fName = req.getParameter("fName");
			String lName = req.getParameter("lName");
			String email = req.getParameter("email");
			Employee e = new Employee((int)session.getAttribute("employeeID"), username, password, fName, lName, email, (int)session.getAttribute("isManager"));
			try {
				edi.updateInfo(e);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		req.getRequestDispatcher("EmployeePage.html").forward(req, resp);
	}
}
