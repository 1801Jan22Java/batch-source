package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.RequestStatus;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class RequestStatusesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao rd = new RequestDaoImpl();
		ArrayList<RequestStatus> requestStatuses = rd.getRequestStatuses();
		ObjectMapper om = new ObjectMapper();
		String jsonValue = "";
		jsonValue = om.writeValueAsString(requestStatuses);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(jsonValue);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
