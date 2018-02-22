package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Request;
import com.revature.dao.RequestDaoImpl;

public class Pending extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int empID = (int)session.getAttribute("employeeID");
		int isManager = (int)session.getAttribute("isManager");
		RequestDaoImpl rdi = new RequestDaoImpl();
		ArrayList<Request> list = new ArrayList<Request>(); 
		try {
			list = rdi.viewPending(empID, isManager);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		Gson gson = new Gson();
		gson.toJson(list, pw);
	}
}
