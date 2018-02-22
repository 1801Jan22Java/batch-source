package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Staff;
import com.revature.dao.ReimbReqDAO;
import com.revature.dao.ReimbReqDAOImpl;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

public class ApproveDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApproveDenyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			resp.setContentType("text/html");
			String sessEmpId = session.getAttribute("currEmpId").toString();
//			System.out.println("Session's employee ID:" + sessEmpId);
			
			String name1 = req.getParameter("approved");
			String name2 = req.getParameter("denied");
//			System.out.println("Name of button: " + name1);
//			System.out.println("Name of button: " + name2);
			if(name1 != null) {
				ReimbReqDAO modRR = new ReimbReqDAOImpl();
				int reqId = Integer.valueOf(name1);
				int manager = Integer.valueOf(sessEmpId);
				int modifiedStatus = modRR.aprvDeny(reqId, "resolved", manager);
				System.out.println("Approved request" + modifiedStatus);
			}
			else if(name2 != null) {
				ReimbReqDAO modRR = new ReimbReqDAOImpl();
				int reqId = Integer.valueOf(name1);
				int manager = Integer.valueOf(sessEmpId);
				int modifiedStatus = modRR.aprvDeny(reqId, "denied", manager);
				System.out.println("Denied request" + modifiedStatus);
			}
			resp.sendRedirect("managerHome");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"message\": session in ApproveDenyServlet is NULL}");
		}
	}

}
