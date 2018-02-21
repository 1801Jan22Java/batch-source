package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Staff;
import com.revature.dao.StaffDAO;
import com.revature.dao.StaffDAOImpl;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			String email = session.getAttribute("email").toString();
			StaffDAO getStaff = new StaffDAOImpl();
			Staff currStaff = getStaff.getStaff(email);
			
			
			PrintWriter pw = resp.getWriter();
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(currStaff);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			pw.print(jsonString);
			pw.flush();
//			resp.setContentType("application/json");
//			resp.getWriter().write("{\"username\":\"" + currStaff.getFirstName() + "\"}");
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\":null}");
		}
	}

}
