package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Request;
import main.ServerManager;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ServerManager serverManager = new ServerManager();
		serverManager.login((String)session.getAttribute("username"), (String)session.getAttribute("password"));
		System.out.println(session);
		resp.setContentType("application/json");
		if (session != null) 
		{
			resp.getWriter().write("{\"employeeId\":\"" + session.getAttribute("employeeId")+"\"");
			resp.getWriter().write(",\"email\":\"" + session.getAttribute("email")+"\"");
			resp.getWriter().write(",\"firstName\":\"" + session.getAttribute("firstName")+"\"");
			resp.getWriter().write(",\"password\":\"" + session.getAttribute("password")+"\"");
			resp.getWriter().write(",\"username\":\"" + session.getAttribute("username")+"\"");
			resp.getWriter().write(",\"username\":\"" + session.getAttribute("requestId")+"\"");
			resp.getWriter().write(",\"lastName\":\"" + session.getAttribute("lastName") + "\"}");
		} 
		else 
		{
			resp.getWriter().write("{\"employeeId\":null}");
		}
	}
}