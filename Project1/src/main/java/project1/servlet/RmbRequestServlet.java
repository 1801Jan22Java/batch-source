package project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.dao.RmbRequestDaoImpl;

public class RmbRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 6133856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		HttpSession session = req.getSession(false);
		Integer id = (Integer)session.getAttribute("employeeId");
		String receiptURL = req.getParameter("receiptURL");
		RmbRequestDaoImpl rdi = new RmbRequestDaoImpl();
		rdi.submitRequest(id, receiptURL);
		resp.sendRedirect("employee");
	}

}
