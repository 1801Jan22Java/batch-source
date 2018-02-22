package project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.dao.EmployeeDaoImpl;

public class UpdatePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 6133856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		HttpSession session = req.getSession(false);
		Integer id = (Integer)session.getAttribute("employeeId");
		String newPassword = req.getParameter("newPassword");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.updateEmployeePassword(newPassword, id);
		resp.sendRedirect("employee");
	}

}
