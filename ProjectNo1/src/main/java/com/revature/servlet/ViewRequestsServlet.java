package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class ViewRequestsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622166310225164697L;

	public ViewRequestsServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean manager = (String) session.getAttribute("is_manager") == "true";
		if (manager) {
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getAllRequests();
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			pw.write(jsonValue);
		} else {
			int id = ((Integer) session.getAttribute("employeeID"));
			PrintWriter pw = resp.getWriter();
			RequestDao rdi = new RequestDaoImpl();
			ArrayList<Request> requests = rdi.getEmployeeRequests(id);
			for (Request r : requests) {
				System.out.println("Request id is : " + r.getRequestID());
			}
			ObjectMapper om = new ObjectMapper();
			String jsonValue = om.writeValueAsString(requests);
			System.out.println("JSON IS : " + jsonValue);
			pw.write(jsonValue);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

}
