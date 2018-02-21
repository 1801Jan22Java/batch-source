package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.*;
import com.revature.dao.*;

public class RequestTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao rd = new RequestDaoImpl();
		ArrayList<RequestType> requestTypes = rd.getRequestTypes();
		ObjectMapper om = new ObjectMapper();
		String jsonValue = "";
		jsonValue = om.writeValueAsString(requestTypes);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(jsonValue);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
