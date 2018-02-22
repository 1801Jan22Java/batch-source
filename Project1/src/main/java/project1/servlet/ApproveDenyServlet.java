package project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1.dao.RmbRequestDaoImpl;

public class ApproveDenyServlet extends HttpServlet {

	private static final long serialVersionUID = 8133856998408315563L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		String manager = (String)(session.getAttribute("firstName")+" "+session.getAttribute("lastName"));
		Integer requestId = Integer.parseInt(req.getParameter("requestId"));
		Integer status = Integer.parseInt(req.getParameter("status"));
		RmbRequestDaoImpl rdi = new RmbRequestDaoImpl();
		rdi.approveDenyRequest(requestId, status, manager);
		resp.sendRedirect("manager");
	}

}

