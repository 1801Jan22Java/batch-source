package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbReq;
import com.revature.dao.ReimbReqDAO;
import com.revature.dao.ReimbReqDAOImpl;

public class GetAllPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllPendingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			ReimbReqDAO getReq = new ReimbReqDAOImpl();
			List<ReimbReq> allPending = getReq.getAllPendingReq();

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(allPending);
			PrintWriter pw = resp.getWriter();
			pw.print(jsonString);
			pw.flush();
		} else {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"username\":null}");
		}
	}

}
