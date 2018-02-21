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
		HttpSession session = req.getSession(false);
		System.out.println(session);
		ServerManager serverManager = new ServerManager();
		ArrayList<Request> reqs = serverManager.reqDao.getRequests(serverManager.currentEmployee.getEmployeeId());
		if (session != null) {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"employeeId\":\"" + session.getAttribute("employeeId")+"\"");
			resp.getWriter().write(",\"size\":\"" + reqs.size()+"\"");
			int c =0;
			for(Request r: reqs)
			{
				resp.getWriter().write(",\"status"+c+"\":\"" + r.getStatus()+"\"");
				resp.getWriter().write(",\"requestId"+c+"\":\"" + r.getRequestId()+"\"");
				resp.getWriter().write(",\"requestAmount"+c+"\":\"" + r.getAmountRequested()+"\"");
				c++;
			}
			resp.getWriter().write(",\"email\":\"" + session.getAttribute("email")+"\"");
			resp.getWriter().write(",\"firstName\":\"" + session.getAttribute("firstName")+"\"");
			resp.getWriter().write(",\"lastName\":\"" + session.getAttribute("lastName") + "\"}");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\":null}");
		}
	}
}