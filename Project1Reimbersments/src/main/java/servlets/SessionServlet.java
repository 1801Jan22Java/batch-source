package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"employeeId\":\"" + session.getAttribute("employeeId")+"\"");
			resp.getWriter().write(",\"email\":\"" + session.getAttribute("email")+"\"");
			resp.getWriter().write(",\"firstName\":\"" + session.getAttribute("firstName")+"\"");
			resp.getWriter().write(",\"requestId\":\"" + session.getAttribute("requestId").toString()+"\"");
			resp.getWriter().write(",\"requestStatus\":\"" + session.getAttribute("requestStatus").toString()+"\"");
			resp.getWriter().write(",\"requestAmount\":\"" + session.getAttribute("requestAmount").toString()+"\"");
			resp.getWriter().write(",\"requestDoc\":\"" + session.getAttribute("requestDoc")+"\"");
			resp.getWriter().write(",\"lastName\":\"" + session.getAttribute("lastName") + "\"}");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\":null}");
		}
	}
}