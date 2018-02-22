package project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import project1.beans.Employee;
import project1.dao.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/Login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee emp = edi.login(username, password);
		if (emp != null) {
			session.setAttribute("employeeId", emp.getEmployeeId());
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("firstName", emp.getFirstName());
			session.setAttribute("lastName", emp.getLastName());
			session.setAttribute("isManager", emp.isManager());
			if (emp.isManager()) {
				resp.sendRedirect("manager");
			} else {
				resp.sendRedirect("employee");
			}
		} else {
			resp.sendRedirect("login");
		}
	}

}
